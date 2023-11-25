package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
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

    @OneToMany(mappedBy = "cliente")
    private List<Servicio> serviciosContratados;

    // Constructor sin parámetros (necesario para JPA)
    public Cliente() {
    }

}