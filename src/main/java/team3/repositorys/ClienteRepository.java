package team3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.gestorincidentesapplication.Cliente;
import team3.gestorincidentesapplication.Cliente;
import team3.services.ClienteService;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {



   /* public static int guardarCliente(Cliente cliente) {

        int clienteId = clienteRepository.guardarCliente(cliente);

        return clienteId;*/
    }
