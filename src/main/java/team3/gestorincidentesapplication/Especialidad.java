package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;
import team3.services.TipoProblemaService;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "especialidad")
@Data
@AllArgsConstructor
@Setter

public class Especialidad{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String descripcion;

    @ManyToMany
    @JoinTable(
            name = "problema_especialidad",
            joinColumns = @JoinColumn(name = "id_problema"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))

    private List<Especialidad> especialidades;

    public Especialidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    public Especialidad() {
    }

}