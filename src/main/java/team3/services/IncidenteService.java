package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.Cliente;
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

    public void guardarIncidente(Incidente incidente) {
        System.out.println("incidente guardado a cliente: " + incidente.getCliente());
        incidenteRepository.save(incidente);
        System.out.println("Incidente guardado exitosamente");
    }
}
