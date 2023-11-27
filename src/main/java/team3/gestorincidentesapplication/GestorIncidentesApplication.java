package team3.gestorincidentesapplication;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;
import team3.services.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "team3.repositorys")
@ComponentScan(basePackages = {"team3.services", "team3.repositorys"})
public class GestorIncidentesApplication {

    private final ClienteService clienteService;
    private final ServicioService servicioService;
    private final TipoProblemaService tipoProblemaService;
    private final EspecialidadService especialidadService;
    private final TecnicoService tecnicoService;
    private final IncidenteService incidenteService;

    @Autowired
    public GestorIncidentesApplication(ClienteService clienteService, ServicioService servicioService, TipoProblemaService tipoProblemaService, EspecialidadService especialidadService, TecnicoService tecnicoService, IncidenteService incidenteService) {
        this.clienteService = clienteService;
        this.servicioService = servicioService;
        this.tipoProblemaService = tipoProblemaService;
        this.especialidadService = especialidadService;
        this.tecnicoService = tecnicoService;
        this.incidenteService = incidenteService;
    }


    public static void main(String[] args) {
        SpringApplication.run(GestorIncidentesApplication.class, args);
    }

    @Transactional
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            Cliente cliente1 = new Cliente(111111, "cliente1@team3.com", "Razón Social 1", "Cliente 1", "Apellido 1");
            Cliente cliente2 = new Cliente(222222, "cliente2@team3.com", "Razón Social 2", "Cliente 2", "Apellido 2");
            Cliente cliente3 = new Cliente(333333, "cliente3@team3.com", "Razón Social 3", "Cliente 3", "Apellido 3");
            Cliente cliente4 = new Cliente(444444, "cliente4@team3.com", "Razón Social 4", "Cliente 4", "Apellido 4");
            Cliente cliente5 = new Cliente(555555, "cliente5@team3.com", "Razón Social 5", "Cliente 5", "Apellido 5");
            Cliente cliente6 = new Cliente(666666, "cliente6@team3.com", "Razón Social 6", "Cliente 6", "Apellido 6");
            Cliente cliente7 = new Cliente(777777, "cliente7@team3.com", "Razón Social 7", "Cliente 7", "Apellido 7");
            Cliente cliente8 = new Cliente(888888, "cliente8@team3.com", "Razón Social 8", "Cliente 8", "Apellido 8");
            Cliente cliente9 = new Cliente(999999, "cliente9@team3.com", "Razón Social 9", "Cliente 9", "Apellido 9");

            cliente1.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));
            cliente1.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente1.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente1.agregarIncidente(new Incidente("Incidente 2", "Sin Internet", "SS"));

            System.out.println("cliente y servicio guardado");

            cliente2.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente2.agregarIncidente(new Incidente("Incidente 1", "Windows desactualizado", "SS"));
            clienteService.guardarCliente(cliente1);
            clienteService.guardarCliente(cliente2);

            cliente3.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));
            cliente3.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente3.agregarServicio(new Servicio("Servicio 4", "Descripción Servicio 4"));
            cliente3.agregarIncidente(new Incidente("Incidente 3", "Problemas Hardware", "SS"));
            clienteService.guardarCliente(cliente3);

            cliente4.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));
            cliente4.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente4.agregarIncidente(new Incidente("Incidente 1", "Windows desactualizado", "SS"));
            //cliente4.agregarIncidente(new Incidente("Incidente 2", "Sin Internet", "SS"));
            clienteService.guardarCliente(cliente4);

            cliente5.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente5.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente5.agregarServicio(new Servicio("Servicio 4", "Descripción Servicio 4"));
            cliente5.agregarIncidente(new Incidente("Incidente 3", "Problemas Hardware", "SS"));
            clienteService.guardarCliente(cliente5);

            cliente6.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente6.agregarIncidente(new Incidente("Incidente 4", "No Signal", "SS"));
            clienteService.guardarCliente(cliente6);

            cliente7.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));
            cliente7.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente7.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente7.agregarIncidente(new Incidente("Incidente 2", "Sin Internet", "SS"));
            //cliente7.agregarIncidente(new Incidente("Incidente 1", "Windows desactualizado", "SS"));
            clienteService.guardarCliente(cliente7);

            cliente8.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente8.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente8.agregarServicio(new Servicio("Servicio 4", "Descripción Servicio 4"));
            cliente8.agregarIncidente(new Incidente("Incidente 4", "No Signal", "SS"));
            clienteService.guardarCliente(cliente8);

            cliente9.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));
            cliente9.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente9.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente9.agregarIncidente(new Incidente("Incidente 2", "Sin Internet", "SS"));
            //cliente9.agregarIncidente(new Incidente("Incidente 1", "Windows desactualizado", "SS"));
            //cliente9.agregarIncidente(new Incidente("Incidente 3", "Problemas Hardware", "SS"));
            //cliente9.agregarIncidente(new Incidente("Incidente 4", "No Signal", "SS"));
            clienteService.guardarCliente(cliente9);

            Tecnico tecnico1 = new Tecnico("Tecnico 1", "el uno");
            Tecnico tecnico2 = new Tecnico("Tecnico 2", "francia");
            Tecnico tecnico3 = new Tecnico("Tecnico 3", "tres");
            Tecnico tecnico4 = new Tecnico("Tecnico 4", "cuatro");
            Tecnico tecnico5 = new Tecnico("Tecnico 5", "cinco");

            tecnico1.agregarEspecialidad(new Especialidad("Especialidad 1","Descripcion 1"));
            tecnico1.agregarEspecialidad(new Especialidad("Especialidad 2","Descripcion 2"));
            tecnico1.agregarIncidente(new Incidente());
            tecnicoService.guardarTecnico(tecnico1);

            tecnico2.agregarEspecialidad(new Especialidad("Especialidad 1","Descripcion 1"));
            tecnico2.agregarEspecialidad(new Especialidad("Especialidad 2","Descripcion 2"));
            tecnico2.agregarEspecialidad(new Especialidad("Especialidad 3","Descripcion 3"));
            tecnicoService.guardarTecnico(tecnico2);

            tecnico3.agregarEspecialidad(new Especialidad("Especialidad 3","Descripcion 3"));
            tecnico3.agregarEspecialidad(new Especialidad("Especialidad 4","Descripcion 4"));
            tecnicoService.guardarTecnico(tecnico3);

            tecnico4.agregarEspecialidad(new Especialidad("Especialidad 1","Descripcion 1"));
            tecnico4.agregarEspecialidad(new Especialidad("Especialidad 2","Descripcion 2"));
            tecnico4.agregarEspecialidad(new Especialidad("Especialidad 3","Descripcion 3"));
            tecnicoService.guardarTecnico(tecnico4);

            tecnico5.agregarEspecialidad(new Especialidad("Especialidad 1","Descripcion 1"));
            tecnico5.agregarEspecialidad(new Especialidad("Especialidad 4","Descripcion 4"));
            tecnicoService.guardarTecnico(tecnico5);

            TipoProblema problema1 = new TipoProblema("Incidente 1",48,96);
            TipoProblema problema2 = new TipoProblema("Incidente 2",24,48);
            TipoProblema problema3 = new TipoProblema("Incidente 3",48,96);
            TipoProblema problema4 = new TipoProblema("Incidente 4",100,200);

            problema1.agregarEspecialidad(new Especialidad("Especialidad 1","Descripcion 1"));
            problema1.agregarIncidente(new Incidente());
            tipoProblemaService.guardarProblema(problema1);

            problema2.agregarEspecialidad(new Especialidad("Especialidad 1","Descripcion 1"));
            problema2.agregarEspecialidad(new Especialidad("Especialidad 2","Descripcion 2"));
            tipoProblemaService.guardarProblema(problema2);

            problema3.agregarEspecialidad(new Especialidad("Especialidad 3","Descripcion 3"));
            problema3.agregarEspecialidad(new Especialidad("Especialidad 4","Descripcion 4"));
            tipoProblemaService.guardarProblema(problema3);

            problema4.agregarEspecialidad(new Especialidad("Especialidad 4","Descripcion 4"));
            problema4.agregarEspecialidad(new Especialidad("Especialidad 3","Descripcion 3"));
            tipoProblemaService.guardarProblema(problema4);




        };
    }
}

/* Metodos tentativos:
Scanner sc = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("Solicitudes:");
                System.out.println("1. Técnico con más incidentes resueltos en los últimos N días");
                System.out.println("2. Técnico con mas incidentes resueltos en determinada especialidad en los últimos N días");
                System.out.println("3. Técnico que más rápido resolvió los incidentes");
                System.out.print("Elija una opción: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        LocalDate fechaIngreso = LocalDate.parse("2023-11-24");
                        LocalDate fechaResolucion = LocalDate.parse("2023-11-25");
                        Tecnico tecnico = service.resueltosporFecha(EstadoEnum.FINALIZADO, fechaIngreso, fechaResolucion);
                        System.out.println("Tecnico con más incidentes resueltos: " + tecnico.getNombre() + " " + tecnico.getApellido());

                    case 2:
                        LocalDate fechaIngreso = LocalDate.parse("2023-11-24");
                        LocalDate fechaResolucion = LocalDate.parse("2023-11-25");
                        Tecnico tecnico = service.resueltosporEspecialidad(EstadoEnum.FINALIZADO, fechaIngreso, fechaResolucion);
                        System.out.println("Técnico con más incidentes resueltos: " + tecnico.getNombre() + " " + tecnico.getApellido());

                    case 3:


                }
            }
            // Consulta para la base de datos para sacar la cantidad de incidentes resueltos por los Tecnicos.

                SELECT tecnico_id, COUNT(*) AS cantidad_incidentes_resueltos
                FROM incidentes
                WHERE estado = 'RESUELTO' // Filtra por estado resuelto
                GROUP BY tecnico_id // Agrupa todos los resultados en tecnico_id
                ORDER BY cantidad_incidentes_resueltos DESC // Ordena los resultados en orden descendente
                LIMIT 1; // Limita el listado a una fila, por lo que solo queda el tecnico con mas reparaciones.






























            */






            /*
            // Crear y guardar clientes
            Cliente cliente1 = new Cliente(111111, "cliente1@team3.com", "Razón Social 1", "Cliente 1", "Apellido 1");
            Cliente cliente2 = new Cliente(222222, "cliente2@team3.com", "Razón Social 2", "Cliente 2", "Apellido 2");
            Cliente cliente3 = new Cliente(333333, "cliente3@team3.com", "Razón Social 3", "Cliente 3", "Apellido 3");
            Cliente cliente4 = new Cliente(444444, "cliente4@team3.com", "Razón Social 4", "Cliente 4", "Apellido 4");


            // Vincular servicios a clientes
            cliente1.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));
            cliente1.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente1.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente2.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));
            cliente3.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));
            cliente3.agregarServicio(new Servicio("Servicio 3", "Descripción Servicio 3"));
            cliente4.agregarServicio(new Servicio("Servicio 2", "Descripción Servicio 2"));



            // Guardar clientes junto a sus servicios en la base de datos
            clienteService.guardarCliente(cliente1);
            //clienteService.guardarCliente(cliente2);
            //clienteService.guardarCliente(cliente3);
            //clienteService.guardarCliente(cliente4);


            System.out.println(" ********* TABLA CLIENTES Y SERVICIOS CREADA ********* ");

            TipoProblema problema1 = new TipoProblema("Problema 1",48,96);
            TipoProblema problema2 = new TipoProblema("Problema 2",24,48);
            TipoProblema problema3 = new TipoProblema("Problema 3",48,96);
            TipoProblema problema4 = new TipoProblema("Problema 4",100,200);
            TipoProblema problema5 = new TipoProblema("Problema 5",80,1000);

            tipoProblemaService.guardarProblema(problema1);
            tipoProblemaService.guardarProblema(problema2);
            tipoProblemaService.guardarProblema(problema3);
            tipoProblemaService.guardarProblema(problema4);
            tipoProblemaService.guardarProblema(problema5);

            System.out.println(" ********* TABLA PROBEMAS CREADA ********* ");

            Especialidad especialidad1 = new Especialidad("Especialidad 1","Descripcion 1");
            Especialidad especialidad2 = new Especialidad("Especialidad 2","Descripcion 2");
            Especialidad especialidad3 = new Especialidad("Especialidad 3","Descripcion 3");
            Especialidad especialidad4 = new Especialidad("Especialidad 4","Descripcion 4");
            Especialidad especialidad5 = new Especialidad("Especialidad 5","Descripcion 5");


            especialidadService.guardarEspecialidad(especialidad1);
            especialidadService.guardarEspecialidad(especialidad2);
            especialidadService.guardarEspecialidad(especialidad3);
            especialidadService.guardarEspecialidad(especialidad4);
            especialidadService.guardarEspecialidad(especialidad5);

            MedioComunicacion medio1 = new MedioComunicacion( MedioEnum.EMAIL, "asd@gmail.com");
            MedioComunicacion medio2 = new MedioComunicacion( MedioEnum.WHATSAPP, "telefono");




            */

