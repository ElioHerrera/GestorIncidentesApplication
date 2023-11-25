package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.GenerationType;

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

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    // Constructor sin parámetros (necesario para JPA)
    public Servicio() {
    }


}