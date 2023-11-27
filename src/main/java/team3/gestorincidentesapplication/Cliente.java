package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import team3.services.IncidenteService;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long cuit;
    private String email;
    private String razonSocial;
    private String nombre;
    private String apellido;
   // private Incidente incidente;


    //@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "cliente_servicio",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> serviciosContratados = new ArrayList<>(); // Inicializa la lista directamente

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Incidente> incidentes = new ArrayList<>();

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cuit=" + cuit +
                ", email='" + email + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                // Excluye la representación de las relaciones para evitar el bucle infinito
                ", serviciosContratados=" + "excluido" +
                ", incidentes=" + "excluido" +
                '}';
    }

    // Constructor sin parámetros (necesario para JPA)
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(long cuit, String email, String razonSocial, String nombre, String apellido) {
        //this.id = id;
        this.cuit = cuit;
        this.email = email;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void agregarServicio(Servicio servicio) {
        serviciosContratados.add(servicio); // Agrega el servicio a la lista del cliente
        servicio.getClientes().add(this); // Agrega el cliente a la lista de clientes del servicio
        System.out.println("Servicio " + servicio.getNombre() + " agregado a Cliente: " + this.nombre);
    }
    public void agregarIncidente(Incidente incidente) {
        //incidente.actualizarEstadoSegunFecha(); // Actualizar estado antes de persistir
        incidentes.add(incidente); // Agrega el incidente a la lista de incidentes del cliente
        incidente.setCliente(this); // Aasocia el incidente con su único cliente
        System.out.println("Incidente " + incidente.getTitulo() + " agregado a Cliente: " + this.nombre);
    }



}

 /*@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long cuit;
    private String email;
    private String razonSocial;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Servicio> serviciosContratados;

    // Constructor sin parámetros (necesario para JPA)
    public Cliente() {
       }

    // Constructor con parámetros
    public Cliente(int id, long cuit, String email, String razonSocial, String nombre, String apellido) {
        this.id = id;
        this.cuit = cuit;
        this.email = email;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.apellido = apellido;
        this.serviciosContratados = new ArrayList<>(); // Inicializa la lista en el constructor
    }


    public void agregarServicio(Servicio servicio) {
        serviciosContratados.add(servicio);
        //this.getServiciosContratados().add(new Servicio());
        //getServiciosContratados().add(new Servicio());

    }
}*/