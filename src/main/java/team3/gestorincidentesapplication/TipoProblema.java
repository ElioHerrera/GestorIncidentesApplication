package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import team3.services.IncidenteService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_problema")
@Data
@AllArgsConstructor
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String tipo;
    private int tiempoEstimado;
    private int tiempoMaximo;
    // private Incidente incidente;


    //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tipo_problema_especialidad",
            joinColumns = @JoinColumn(name = "tipoProblema_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
    private List<Especialidad> especialidades = new ArrayList<>(); // Inicializa la lista directamente

    @OneToMany(mappedBy = "tipoProblema", cascade = CascadeType.ALL)
    private List<Incidente> incidentes = new ArrayList<>();

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", Problema=" + tipo +
                ", TiempoEstimado='" + tiempoEstimado + '\'' +
                ", TiempoMaximo='" + tiempoMaximo + '\'' +
                // Excluye la representación de las relaciones para evitar el bucle infinito
                ", especialidades=" + "excluido" +
                ", incidentes=" + "excluido" +
                '}';
    }

    // Constructor sin parámetros (necesario para JPA)
    public TipoProblema() {
    }

    // Constructor con parámetros
    public TipoProblema(String tipo, int tiempoEstimado, int tiempoMaximo) {
        //this.id = id;
        this.tipo = tipo;
        this.tiempoEstimado = tiempoEstimado;
        this.tiempoMaximo = tiempoMaximo;

    }

    public void agregarEspecialidad(Especialidad especialidad) {
        especialidades.add(especialidad); // Agrega la especialidad a la lista del tecnico
        especialidad.getTipoProblemas().add(this); // Agrega el tecnico a la lista de tecnicos de la especialidad
        System.out.println("Servicio " + especialidad.getNombre() + " agregado a Cliente: " + this.tipo);
    }
    public void agregarIncidente(Incidente incidente) {
        //incidente.actualizarEstadoSegunFecha(); // Actualizar estado antes de persistir
        incidentes.add(incidente); // Agrega el incidente a la lista de incidentes del cliente
        incidente.setTipoProblema(this); // Aasocia el incidente con su único cliente
        System.out.println("Incidente " + incidente.getTitulo() + " agregado a Cliente: " + this.tipo);
    }



}
    /*

    package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_problema")
@Data
@AllArgsConstructor
@Setter

public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;
    private int tiempoEstimado;
    private int tiempoMaximo;

    @ManyToMany
    @JoinTable(
            name = "tipo_problema_especialidad",
            joinColumns = @JoinColumn(name = "id_tipo_problema"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades;

    public TipoProblema(String tipo,int tiempoEstimado, int tiempoMaximo) {
        this.id = id;
        this.tipo = tipo;
        this.tiempoEstimado = tiempoEstimado;
        this.tiempoMaximo = tiempoMaximo;
    }
    public TipoProblema() {

    }




    public void agregarEspecialidad(Especialidad especialidad) {
        especialidades.add(especialidad);
        especialidad.getTipoProblema().add(this);
        System.out.println("Servicio agregado a Cliente: " + this.id);
    }


 */
