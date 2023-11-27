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

            Incidente incidente1 = new Incidente("sss","dessss",EstadoEnum.INCOMPLETO,"SS");

            incidente1.agregarCliente(cliente1);
            cliente1.agregarServicio(new Servicio("Servicio 1", "Descripción Servicio 1"));

            incidenteService.guardarIncidente(incidente1);





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

            Tecnico tecnico1 = new Tecnico("Tecnico 1", "el uno");
            Tecnico tecnico2 = new Tecnico("Tecnico 2", "francia");
            Tecnico tecnico3 = new Tecnico("Tecnico 3", "tres");
            Tecnico tecnico4 = new Tecnico("Tecnico 4", "cuatro");
            Tecnico tecnico5 = new Tecnico("Tecnico 5", "cinco");

            tecnicoService.guardarTecnico(tecnico1);
            tecnicoService.guardarTecnico(tecnico2);
            tecnicoService.guardarTecnico(tecnico3);
            tecnicoService.guardarTecnico(tecnico4);
            tecnicoService.guardarTecnico(tecnico5);
            */

        };
    }
}
