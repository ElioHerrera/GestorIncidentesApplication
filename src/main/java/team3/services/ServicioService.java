package team3.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.Servicio;
import team3.repositorys.ServicioRepository;

@Service
public class ServicioService {

    ServicioRepository servicioRepository;

    @Autowired
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    // Método para guardar un servicio
    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }

}
