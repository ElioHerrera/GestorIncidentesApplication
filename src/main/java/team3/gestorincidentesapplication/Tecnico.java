package team3.gestorincidentesapplication;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tecnico")
@Data
@AllArgsConstructor
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String apellido;

    @ManyToMany
    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "id_tecnico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidad"))
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnico")
    private List<MedioComunicacion> mediosComunicacion;
}