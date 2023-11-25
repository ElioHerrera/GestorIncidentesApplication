package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.Cliente;
import team3.repositorys.ClienteRepository;


@Service
public class ClienteService {

    ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    // Ejemplo de método en el servicio para guardar un nuevo cliente
    public void guardarCliente(Cliente cliente) {

        clienteRepository.save(cliente);
    }

}