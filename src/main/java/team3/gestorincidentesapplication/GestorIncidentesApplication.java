package team3.gestorincidentesapplication;

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

    @Autowired
    public GestorIncidentesApplication(ClienteService clienteService, ServicioService servicioService, TipoProblemaService tipoProblemaService, EspecialidadService especialidadService, TecnicoService tecnicoService) {
        this.clienteService = clienteService;
        this.servicioService = servicioService;
        this.tipoProblemaService = tipoProblemaService;
        this.especialidadService = especialidadService;
        this.tecnicoService = tecnicoService;
    }


    public static void main(String[] args) {
        SpringApplication.run(GestorIncidentesApplication.class, args);
    }

    @Transactional
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

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
            clienteService.guardarCliente(cliente2);
            clienteService.guardarCliente(cliente3);
            clienteService.guardarCliente(cliente4);
            System.out.println("fin ");


           /* // Crear y guardar servicios
            Servicio servicio1 = new Servicio(1,"Servicio 1", "Descripción Servicio 1");
            Servicio servicio2 = new Servicio(2,"Servicio 2", "Descripción Servicio 2");
            Servicio servicio3 = new Servicio(3,"Servicio 3", "Descripción Servicio 3");
            Servicio servicio4 = new Servicio(4,"Servicio 4", "Descripción Servicio 4");

            servicioService.guardarServicio(servicio1);
            servicioService.guardarServicio(servicio2);
            servicioService.guardarServicio(servicio3);
            servicioService.guardarServicio(servicio4);

            // Vincular servicios a clientes
            cliente1.agregarServicio(servicio1);
            cliente1.agregarServicio(servicio2);
            cliente2.agregarServicio(servicio4);
            cliente3.agregarServicio(servicio3);
            cliente4.agregarServicio(servicio3);
            cliente4.agregarServicio(servicio1);
            cliente4.agregarServicio(servicio2);

            cliente1.setId(clienteService.guardarCliente(cliente1));
            cliente2.setId(clienteService.guardarCliente(cliente2));
            cliente3.setId(clienteService.guardarCliente(cliente3));
            cliente4.setId(clienteService.guardarCliente(cliente4));*/


            TipoProblema problema1 = new TipoProblema(1,"Problema 1",48,96);
            TipoProblema problema2 = new TipoProblema(2,"Problema 2",24,48);
            TipoProblema problema3 = new TipoProblema(3,"Problema 3",48,96);
            TipoProblema problema4 = new TipoProblema(4,"Problema 4",100,200);
            TipoProblema problema5 = new TipoProblema(5,"Problema 5",80,1000);

            tipoProblemaService.guardarProblema(problema1);
            tipoProblemaService.guardarProblema(problema2);
            tipoProblemaService.guardarProblema(problema3);
            tipoProblemaService.guardarProblema(problema4);
            tipoProblemaService.guardarProblema(problema5);


            Especialidad especialidad1 = new Especialidad(1,"Especialidad 1","Descripcion 1");
            Especialidad especialidad2 = new Especialidad(2,"Especialidad 2","Descripcion 2");
            Especialidad especialidad3 = new Especialidad(3,"Especialidad 3","Descripcion 3");
            Especialidad especialidad4 = new Especialidad(4,"Especialidad 4","Descripcion 4");
            Especialidad especialidad5 = new Especialidad(5,"Especialidad 5","Descripcion 5");

            especialidadService.guardarEspecialidad(especialidad1);
            especialidadService.guardarEspecialidad(especialidad2);
            especialidadService.guardarEspecialidad(especialidad3);
            especialidadService.guardarEspecialidad(especialidad4);
            especialidadService.guardarEspecialidad(especialidad5);

            MedioComunicacion medio1 = new MedioComunicacion(1, MedioEnum.EMAIL, "asd@gmail.com");
            MedioComunicacion medio2 = new MedioComunicacion(1, MedioEnum.WHATSAPP, "telefono");

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

        };
    }
}
