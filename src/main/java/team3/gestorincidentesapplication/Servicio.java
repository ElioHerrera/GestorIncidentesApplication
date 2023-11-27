package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "servicio")
@Data
@AllArgsConstructor

public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;




    @ManyToMany(mappedBy = "serviciosContratados")
    private List<Cliente> clientes = new ArrayList<>(); // Inicializa la lista directamente



    // Constructor con parámetros
    public Servicio(String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Constructor sin parámetros (necesario para JPA)
    public Servicio() {
    }



}
