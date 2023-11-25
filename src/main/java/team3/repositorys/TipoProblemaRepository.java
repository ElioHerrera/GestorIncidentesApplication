package team3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.gestorincidentesapplication.TipoProblema;

@Repository
public interface TipoProblemaRepository extends JpaRepository<TipoProblema, Integer> {
}
