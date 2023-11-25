package team3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.gestorincidentesapplication.Servicio;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

}