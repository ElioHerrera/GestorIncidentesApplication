package team3.gestorincidentesapplication;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.GenerationType;


@Entity
@Table(name = "medio_comunicacion")
@Data

public class MedioComunicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private MedioEnum medio;

    private String contacto;

    @ManyToOne
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id")
    private Tecnico tecnico;
}