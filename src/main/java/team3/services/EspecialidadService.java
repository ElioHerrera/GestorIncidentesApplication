package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.Especialidad;
import team3.repositorys.EspecialidadRepository;

@Service
public class EspecialidadService {

    EspecialidadRepository especialidadRepository;

    @Autowired
    public EspecialidadService(EspecialidadRepository especialidadRepositery) {
        this.especialidadRepository = especialidadRepository;
    }

    public void guardarEspecialidad(Especialidad especialidad) {

     especialidadRepository.save(especialidad);
    }

}
