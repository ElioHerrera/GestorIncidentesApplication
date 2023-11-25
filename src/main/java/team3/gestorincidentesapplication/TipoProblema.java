package team3.gestorincidentesapplication;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tipo_problema")
@Data

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
}
