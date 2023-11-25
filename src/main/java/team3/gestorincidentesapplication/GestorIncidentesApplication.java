package team3.gestorincidentesapplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import team3.services.ClienteService;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "team3.repositorys")
@ComponentScan(basePackages = {"team3.services", "team3.repositorys"})
public class GestorIncidentesApplication {

    private final ClienteService clienteService;

    @Autowired
    public GestorIncidentesApplication(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public static void main(String[] args) {
        SpringApplication.run(GestorIncidentesApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            List<Servicio> servicios = new ArrayList<>();

            Cliente cliente = new Cliente(0,
                    20334060420L,
                    "ddd",
                    "ssss",
                    "elio",
                    "dddd",
                    servicios);


            Servicio servicio = new Servicio(1,
                    "pro",
                    "xxxx",
                    cliente);

            clienteService.guardarCliente(cliente);

            System.out.println(servicio.getNombre());

         // tabla creada
        };
    }

}
