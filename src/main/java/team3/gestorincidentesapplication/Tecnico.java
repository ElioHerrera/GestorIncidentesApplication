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

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL)
    private List<Incidente> incidentes = new ArrayList<>();

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
        especialidades.add(especialidad); // Agrega la especialidad a la lista del tecnico
        especialidad.getTecnicos().add(this); // Agrega el tecnico a la lista de tecnicos de la especialidad
        System.out.println("Servicio " + especialidad.getNombre() + " agregado a Cliente: " + this.nombre);
    }
    public void agregarIncidente(Incidente incidente) {
        //incidente.actualizarEstadoSegunFecha(); // Actualizar estado antes de persistir
        incidentes.add(incidente); // Agrega el incidente a la lista de incidentes del tecnic
        incidente.setTecnico(this); // Aasocia el incidente con su único cliente
        System.out.println("Incidente " + incidente.getTitulo() + " agregado a Cliente: " + this.nombre);
    }



}




/*package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
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

    @ManyToMany
    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnico")
    private List<MedioComunicacion> mediosComunicacion;

    public Tecnico(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
}}*/