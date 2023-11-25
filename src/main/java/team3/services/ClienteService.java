package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.Cliente;
import team3.repositorys.ClienteRepository;
import team3.gestorincidentesapplication.Cliente;


@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }
    public int guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente).getId();

    }




    // Ejemplo de método en el servicio para guardar un nuevo cliente
    /*public Cliente guardarCliente(Cliente cliente) {

        return clienteRepository.save(cliente);*/

    /*public int guardarCliente(Cliente cliente) {

        int clienteId = ClienteRepository.guardarCliente(cliente);

        return clienteId;
    }*/

}
