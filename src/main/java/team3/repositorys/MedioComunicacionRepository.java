package team3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.gestorincidentesapplication.MedioComunicacion;

@Repository
public interface MedioComunicacionRepository extends JpaRepository<MedioComunicacion, Integer> {
}
