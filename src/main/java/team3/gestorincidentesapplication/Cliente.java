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
}