package team3.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import team3.gestorincidentesapplication.Tecnico;

import java.util.Optional;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
    Optional<Tecnico> findByNombre(Tecnico nombreTecnico);
}
