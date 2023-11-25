package team3.gestorincidentesapplication;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
@Table(name = "servicio")
@Data

public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}