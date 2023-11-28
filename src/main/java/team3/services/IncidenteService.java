package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team3.gestorincidentesapplication.Cliente;
import team3.repositorys.IncidenteRepository;
import team3.gestorincidentesapplication.Incidente;

import java.util.List;


@Service
public class IncidenteService {
    IncidenteRepository incidenteRepository;

    @Autowired
    public IncidenteService(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    // Ejemplo de método en el servicio para guardar un nuevo cliente
    public void guardarIncidente(Incidente incidente) {
        incidenteRepository.save(incidente);
    }


    // Metodo consultar Todos los incidentes
    public List<Incidente> obtenerTodosIncidentes() {
        return incidenteRepository.findAll();
    }

    public Incidente obtenerIncidentePorId(int incidenteId) {
        return incidenteRepository.findById(incidenteId).orElse(null);
    }


}
