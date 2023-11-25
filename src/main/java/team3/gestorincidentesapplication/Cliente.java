package team3.gestorincidentesapplication;
//Tito
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
@Data

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
}