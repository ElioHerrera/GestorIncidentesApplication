package team3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.gestorincidentesapplication.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}