package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
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

    @OneToMany(mappedBy = "cliente")
    private List<Incidente> incidentes = new ArrayList<>();

    // Constructor sin parámetros (necesario para JPA)
    public Cliente() {
    }

    // Constructor con parámetros
    public Cliente(long cuit, String email, String razonSocial, String nombre, String apellido) {
        this.id = id;
        this.cuit = cuit;
        this.email = email;
        this.razonSocial = razonSocial;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void agregarServicio(Servicio servicio) {
        serviciosContratados.add(servicio);
        servicio.getClientes().add(this);
        System.out.println("Servicio agregado a Cliente: " + this.id);
    }
    public void agregarIncidente(Incidente incidente) {
        incidentes.add(incidente);
        incidente.setCliente(this); // Establecer la relación bidireccional
        System.out.println("Incidente agregado a Cliente: " + this.id);
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