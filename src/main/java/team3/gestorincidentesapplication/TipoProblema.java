package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_problema")
@Data
@AllArgsConstructor
@Setter

public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String tipo;
    private int tiempoEstimado;
    private int tiempoMaximo;

    @ManyToMany
    @JoinTable(
            name = "tipo_problema_especialidad",
            joinColumns = @JoinColumn(name = "id_tipo_problema"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades;

    public TipoProblema(String tipo,int tiempoEstimado, int tiempoMaximo) {
        this.id = id;
        this.tipo = tipo;
        this.tiempoEstimado = tiempoEstimado;
        this.tiempoMaximo = tiempoMaximo;
    }
    public TipoProblema() {

    }
    /*
    public void agregarEspecialidad(Especialidad especialidad) {
        especialidades.add(especialidad);
        especialidad.getTipoProblema().add(this);
        System.out.println("Servicio agregado a Cliente: " + this.id);
    }


 */
    }