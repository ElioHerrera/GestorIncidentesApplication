package team3.gestorincidentesapplication;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "especialidad")
@Data
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;
}