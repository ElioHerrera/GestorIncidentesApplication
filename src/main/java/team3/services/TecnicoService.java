package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.Tecnico;
import team3.repositorys.TecnicoRepository;

@Service
public class TecnicoService {
    TecnicoRepository tecnicoRepository;

    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    // Ejemplo de método en el servicio para guardar un nuevo tecnico
    public void guardarCliente(Tecnico tecnico) {

        tecnicoRepository.save(tecnico);
    }
}
