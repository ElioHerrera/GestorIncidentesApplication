package team3.gestorincidentesapplication;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public Incidente(String titulo, String descripcion, String consideraciones) {
        //this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaIngreso = new Date(); // Establece la fecha de ingreso al momento de la creación
        this.fechaEstimadaResolucion = calcularFechaEstimadaResolucion(); // Calcula la fecha estimada de resolución
        this.fechaResolucion = null;
        this.estado = devolverEstadoSegunFecha();
        this.consideraciones = consideraciones;
    }

    public Incidente() {
    }


    private Date calcularFechaEstimadaResolucion() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        return calendar.getTime();
    }

    // CORREGIR MEDOTO 
    private EstadoEnum devolverEstadoSegunFecha() {
        Date fechaActual = new Date();

        if (fechaEstimadaResolucion == null) {
            // Si no hay fecha estimada, el estado es EN_PROCESO
            return EstadoEnum.EN_PROCESO;
        }

        if (fechaEstimadaResolucion.before(fechaActual)) {
            // Si la fecha estimada ha pasado, el estado es EN_PROCESO
            return EstadoEnum.EN_PROCESO;
        } else if (fechaResolucion != null && fechaResolucion.before(fechaActual)) {
            // Si hay fecha de resolución y ha pasado, el estado es FINALIZADO
            return EstadoEnum.FINALIZADO;
        }

        // Si no se cumplen las condiciones anteriores, el estado es INCOMPLETO
        return EstadoEnum.EN_PROCESO;
    }


}




