package team3.gestorincidentesapplication;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incidente")
@Data

public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;
    private String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstimadaResolucion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaResolucion;

    @Enumerated(EnumType.STRING)
    private EstadoEnum estado;

    private String consideraciones;



    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

/*

@ManyToMany
    @JoinTable(
            name = "incidente_tipo_problema",
            joinColumns = @JoinColumn(name = "id_incidente"),
            inverseJoinColumns = @JoinColumn(name = "id_tipo_problema"))
    private List<TipoProblema> tipoProblemas;

    @ManyToOne
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id")
    private Tecnico tecnico;

        @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio servicio;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id")
    private Especialidad especialidad;
*/
    public Incidente(String titulo, String descripcion, EstadoEnum estado, String consideraciones) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        //this.fechaIngreso = fechaIngreso;
        //this.fechaEstimadaResolucion = fechaEstimadaResolucion;
        //this.fechaResolucion = fechaResolucion;
        this.estado = estado;
        this.consideraciones = consideraciones;
    }
    public Incidente(){
    }


    public void agregarCliente(Cliente cliente) {
        this.cliente = cliente;
        cliente.getIncidentes().add(this); // Agregar este incidente a la lista de incidentes del cliente
        System.out.println("Cliente agregado");
    }


}
