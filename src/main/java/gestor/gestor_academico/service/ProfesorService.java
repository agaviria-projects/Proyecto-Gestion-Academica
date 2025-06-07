package gestor.gestor_academico.service;


import gestor.gestor_academico.dto.ProfesorDTO;
import gestor.gestor_academico.model.Estudiante;
import gestor.gestor_academico.model.Profesor;
import gestor.gestor_academico.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> listarProfesores(){
        return profesorRepository.findAll();
    }

    public Profesor guardarProfesor(Profesor profesor){
        return profesorRepository.save(profesor);
    }

    public Profesor buscarPorId(Long id){
        return profesorRepository.findById(id).orElse(null);
    }
    public Profesor actualizarProfesor(Long id, Profesor profesor) {
        if (profesorRepository.existsById(id)) {
            profesor.setId(id);
            return profesorRepository.save(profesor);
        }
        return null;
    }

    public Long contarProfesores(){
        return profesorRepository.count();
    }

    public void eliminarProfesor(Long id){
        profesorRepository.deleteById(id);
    }



    public List<ProfesorDTO> obtenerTodosDTO() {
        return profesorRepository.findAll().stream()
                .map(p -> {
                    ProfesorDTO dto = new ProfesorDTO();
                    dto.setId(p.getId());
                    dto.setNombre(p.getNombre());
                    dto.setEspecialidad(p.getEspecialidad());
                    dto.setEmail(p.getEmail());
                    return dto;
                })
                .collect(Collectors.toList());
    }

}

