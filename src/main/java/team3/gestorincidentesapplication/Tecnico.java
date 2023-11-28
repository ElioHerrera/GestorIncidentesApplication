package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import team3.services.IncidenteService;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tecnico")
@Data
@AllArgsConstructor
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;
    // private Incidente incidente;


    //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades = new ArrayList<>(); // Inicializa la lista directamente

    /*
    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private List<Incidente> incidentes = new ArrayList<>();
    */

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private List<MedioComunicacion> preferido;


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                // Excluye la representación de las relaciones para evitar el bucle infinito
                ", especialidades =" + "excluido" +
                ", incidentes=" + "excluido" +
                '}';
    }

    // Constructor sin parámetros (necesario para JPA)
    public Tecnico() {
    }

    // Constructor con parámetros
    public Tecnico(String nombre, String apellido) {
        //this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void agregarEspecialidad(Especialidad especialidad) {
        this.especialidades.add(especialidad);
        especialidad.getTecnicos().add(this);
        System.out.println("Servicio " + especialidad.getNombre() + " agregado a Cliente: " + this.nombre);
    }


    public void agregarMedio(MedioComunicacion medioComunicacion, String contacto) {
        MedioComunicacion nuevoMedio = new MedioComunicacion();
        medioComunicacion.add(nuevoMedio);
        System.out.println("Nuevo medio de comunicacion agregado:" + this.nombre);

    }
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }


}