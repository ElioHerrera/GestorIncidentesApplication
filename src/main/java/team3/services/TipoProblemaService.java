package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.TipoProblema;
import team3.repositorys.TipoProblemaRepository;


@Service
public class TipoProblemaService {
    TipoProblemaRepository tipoProblemaRepository;

    @Autowired
    public TipoProblemaService(TipoProblemaRepository tipoProblemaRepository) {
        this.tipoProblemaRepository = tipoProblemaRepository;
    }

    // Ejemplo de método en el servicio para guardar un nuevo cliente
    public void guardarProblema(TipoProblema tipoProblema) {

        tipoProblemaRepository.save(tipoProblema);
    }

}
