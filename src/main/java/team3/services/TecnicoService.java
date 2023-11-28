package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.MedioComunicacion;
import team3.gestorincidentesapplication.Tecnico;
import team3.repositorys.TecnicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    TecnicoRepository tecnicoRepository;

    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    // Ejemplo de método en el servicio para guardar un nuevo tecnico
    public void guardarTecnico(Tecnico tecnico) {

        tecnicoRepository.save(tecnico);
    }

    public List<Tecnico> obtenerTodosTecnicos() {
        return tecnicoRepository.findAll();
    }

    public Tecnico obtenerTecnicoPorId(int tecnicoId) {
        return tecnicoRepository.findById(tecnicoId).orElse(null);
    }


}