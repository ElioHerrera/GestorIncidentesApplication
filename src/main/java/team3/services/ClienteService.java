package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team3.gestorincidentesapplication.Cliente;
import team3.gestorincidentesapplication.Incidente;
import team3.gestorincidentesapplication.Servicio;
import team3.repositorys.ClienteRepository;

import java.util.List;


@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }
    public void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " guardado exitosamente");
    }



    @Transactional
    public List<Cliente> obtenerTodosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        // Imprimir los clientes en la consola
        System.out.println("------------------------------------------------");
        System.out.println("           LISTA DE CLIENTES");
        System.out.println("------------------------------------------------");
        for (Cliente cliente : clientes) {
            System.out.print("ID: " + cliente.getId() + " ");
            System.out.print("Nombre: " + cliente.getNombre() + " ");
            System.out.print("Apellido: " + cliente.getApellido() + " \n");
            System.out.print("Razón Social: " + cliente.getRazonSocial() + " \n");
            System.out.print("Email: " + cliente.getEmail() + " \n");
            System.out.print("Cuit: " + cliente.getCuit() + " \n");

            // Cargar la colección de serviciosContratados dentro de la transacción
            cliente.getServiciosContratados().size();

            // Imprimir los servicios contratados
            System.out.println("-------------->   Servicios Contratados:");
            for (Servicio servicio : cliente.getServiciosContratados()) {
                System.out.println("- " + servicio.getNombre());
            }
            System.out.println("-------------->   Incidentes:");
            for (Incidente incidente : cliente.getIncidentes()) {
                System.out.println("- " + incidente.getTitulo());
            }

            System.out.println("****************************");
        }

        return clientes;
    }

}





// Ejemplo de método en el servicio para guardar un nuevo cliente
    /*public Cliente guardarCliente(Cliente cliente) {

        return clienteRepository.save(cliente);*/

    /*public int guardarCliente(Cliente cliente) {

        int clienteId = ClienteRepository.guardarCliente(cliente);

        return clienteId;
    }*/