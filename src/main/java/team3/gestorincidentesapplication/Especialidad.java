package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "especialidad")
@Data
@AllArgsConstructor

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

   /* @ManyToMany(mappedBy = "especialidades")*/
    private List<Tecnico> tecnicos = new ArrayList<>(); // Inicializa la lista directamente
    private List<TipoProblema> tipoProblemas = new ArrayList<>();
    public Especialidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tecnicos = new ArrayList<>();
    }

    public Especialidad() {
        this.tecnicos = new ArrayList<>();
    }

}