package team3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.gestorincidentesapplication.Incidente;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {
}
