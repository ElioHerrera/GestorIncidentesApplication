package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.MedioComunicacion;
import team3.repositorys.MedioComunicacionRepository;

@Service
public class MedioComunicacionService {

    MedioComunicacionRepository medioComunicacionRepository;

    @Autowired
    public MedioComunicacionService(MedioComunicacionRepository medioComunicacionRepository) {
        this.medioComunicacionRepository = medioComunicacionRepository;
    }

    // Ejemplo de método en el servicio para guardar un nuevo cliente
    public void guardarMedioComunicacion(MedioComunicacion medioComunicacion) {

        medioComunicacionRepository.save(medioComunicacion);
    }
}
