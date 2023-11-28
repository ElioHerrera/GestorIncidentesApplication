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
    private final EspecialidadService especialidadService;
    private final TecnicoService tecnicoService;
    private final IncidenteService incidenteService;

    @Autowired
    public GestorIncidentesApplication(ClienteService clienteService, ServicioService servicioService, EspecialidadService especialidadService, TecnicoService tecnicoService, IncidenteService incidenteService) {
        this.clienteService = clienteService;
        this.servicioService = servicioService;
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

            // Después de haber inyectado RelacionService donde sea necesario

            System.out.println(".......clientes SAVE");

            Tecnico tecnico1 = new Tecnico("Tecnico 1", "el uno");
            Tecnico tecnico2 = new Tecnico("Tecnico 2", "francia");
            Tecnico tecnico3 = new Tecnico("Tecnico 3", "tres");
            Tecnico tecnico4 = new Tecnico("Tecnico 4", "cuatro");
            Tecnico tecnico5 = new Tecnico("Tecnico 5", "cinco");

            System.out.println("tecnicos creados");

            tecnico1.agregarEspecialidad(new Especialidad("Especialidad 1","Descripcion 1"));
            tecnico1.agregarEspecialidad(new Especialidad("Especialidad 2","Descripcion 2"));

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

            /*
            MedioComunicacion medio1 = new MedioComunicacion(MedioEnum.WHATSAPP,"Whats App");
            tecnico1.agregarMedio(medio1,"3413564545");
            */

            //Solicitamos Datos de los Clientes
            clienteService.obtenerTodosClientes();

            //Solicitamos Datos de los Tecnicos
            tecnicoService.obtenerTodosTecnicos();


        };
    }

}

