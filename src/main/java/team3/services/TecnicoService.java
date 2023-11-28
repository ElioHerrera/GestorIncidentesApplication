package team3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team3.gestorincidentesapplication.Especialidad;
import team3.gestorincidentesapplication.Tecnico;
import team3.repositorys.TecnicoRepository;
import java.util.List;

@Service
public class TecnicoService {
    TecnicoRepository tecnicoRepository;

    @Autowired
    public TecnicoService(TecnicoRepository tecnicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
    }

    public void guardarTecnico(Tecnico tecnico) {
        tecnicoRepository.save(tecnico);
    }

    @Transactional
    public List<Tecnico> obtenerTodosTecnicos() {
        List<Tecnico> tecnicos = tecnicoRepository.findAll();
        System.out.println("------------------------------------------------");
        System.out.println("           LISTA DE TÉCNICOS");
        System.out.println("------------------------------------------------");
        for (Tecnico tecnico : tecnicos) {
            System.out.print("ID: " + tecnico.getId() + " ");
            System.out.print("Nombre: " + tecnico.getNombre() + " ");
            System.out.print("Apellido: " + tecnico.getApellido() + " \n");

            tecnico.getEspecialidades().size();

            System.out.println("-------------->   Especialidades:");
            for (Especialidad especialidad : tecnico.getEspecialidades()) {
                System.out.println("- " + especialidad.getNombre());
            }
            System.out.println("****************************");
        }
        return tecnicos;
    }
}



