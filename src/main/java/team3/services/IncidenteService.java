package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.repositorys.IncidenteRepository;
import team3.gestorincidentesapplication.Incidente;


@Service
public class IncidenteService {
    IncidenteRepository incidenteRepository;

    @Autowired
    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    // Ejemplo de método en el servicio para guardar un nuevo cliente
    public void guardarCliente(Incidente incidente) {

        incidenteRepository.save(incidente);
    }
}
