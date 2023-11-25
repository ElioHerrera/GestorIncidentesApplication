package team3.gestorincidentesapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;
import team3.services.ClienteService;
import team3.services.ServicioService;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "team3.repositorys")
@ComponentScan(basePackages = {"team3.services", "team3.repositorys"})
public class GestorIncidentesApplication {

    private final ClienteService clienteService;
    private final ServicioService servicioService;

    @Autowired
    public GestorIncidentesApplication(ClienteService clienteService, ServicioService servicioService) {
        this.clienteService = clienteService;
        this.servicioService = servicioService;
    }


    public static void main(String[] args) {
        SpringApplication.run(GestorIncidentesApplication.class, args);
    }

    @Transactional
    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            // Crear y guardar clientes
            Cliente cliente1 = new Cliente(1, 111111, "cliente1@team3.com", "Razón Social 1", "Cliente 1", "Apellido 1");
            Cliente cliente2 = new Cliente(2,222222, "cliente2@team3.com", "Razón Social 2", "Cliente 2", "Apellido 2");
            Cliente cliente3 = new Cliente(3,333333, "cliente3@team3.com", "Razón Social 3", "Cliente 3", "Apellido 3");
            Cliente cliente4 = new Cliente(4,444444, "cliente4@team3.com", "Razón Social 4", "Cliente 4", "Apellido 4");


            clienteService.guardarCliente(cliente1);
            clienteService.guardarCliente(cliente2);
            clienteService.guardarCliente(cliente3);
            clienteService.guardarCliente(cliente4);


            // Crear y guardar servicios
            Servicio servicio1 = new Servicio(1,"Servicio 1", "Descripción Servicio 1");
            Servicio servicio2 = new Servicio(2,"Servicio 2", "Descripción Servicio 2");
            Servicio servicio3 = new Servicio(3,"Servicio 3", "Descripción Servicio 3");
            Servicio servicio4 = new Servicio(4,"Servicio 4", "Descripción Servicio 4");



            // Vincular servicios a clientes
            cliente1.agregarServicio(servicio1); //SE BORRA
            cliente1.agregarServicio(servicio2); //SETEA
            cliente2.agregarServicio(servicio4);
            cliente3.agregarServicio(servicio3);
            cliente4.agregarServicio(servicio3); //SE BORRA
            cliente4.agregarServicio(servicio1); //SETEA
            cliente4.agregarServicio(servicio2); //NUEVO SETEA

            // Guardar servicios después de vincularlos
            servicioService.guardarServicio(servicio1);
            servicioService.guardarServicio(servicio2);
            servicioService.guardarServicio(servicio3);
            servicioService.guardarServicio(servicio4);
            // ... (guardar otros servicios)




        };
    }

}
