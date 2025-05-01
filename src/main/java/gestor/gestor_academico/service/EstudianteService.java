package gestor.gestor_academico.service;

import gestor.gestor_academico.model.Estudiante; // importar la clase Estudiante
import gestor.gestor_academico.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> listarEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Estudiante guardarEstudiante(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }

    public Estudiante buscarPorId(Long id){
        return estudianteRepository.findById(id).orElse(null);
    }
    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        if (estudianteRepository.existsById(id)) {
            estudiante.setId(id);
            return estudianteRepository.save(estudiante);
        }
        return null;
    }

    public void eliminarEstudiante(Long id){
        estudianteRepository.deleteById(id);
    }
}
