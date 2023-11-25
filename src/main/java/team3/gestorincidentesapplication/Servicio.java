package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
@Table(name = "servicio")
@Data
@AllArgsConstructor
@Setter
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

    // Constructor con parámetros
    public Servicio(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Constructor sin parámetros (necesario para JPA)
    public Servicio() {
    }


}