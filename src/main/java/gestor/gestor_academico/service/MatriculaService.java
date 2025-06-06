package gestor.gestor_academico.service;

import gestor.gestor_academico.dto.MatriculaDTO;
import gestor.gestor_academico.model.Matricula;
import gestor.gestor_academico.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula>listarMatriculas(){
        return matriculaRepository.findAll();
    }

    public Matricula buscarPorId(Long id){
        return matriculaRepository.findById(id).orElse(null);
    }

    public Matricula guardarMatricula(Matricula matricula){
        return matriculaRepository.save(matricula);
    }

    public List<Matricula> listarPorEstudiante(Long idEstudiante) {
        return matriculaRepository.findByEstudianteId(idEstudiante);
    }


    public Matricula actualizarMatricula(Long id, Matricula matricula){
        if(matriculaRepository.existsById(id)){
            matricula.setId(id);
            return matriculaRepository.save(matricula);
        }
        return null;
    }

    public Long contarMatriculas(){
        return matriculaRepository.count();
    }

    public void eliminarMatricula(Long id){
        matriculaRepository.deleteById(id);
    }

    public List<MatriculaDTO> obtenerMatriculasPorProfesor(Long idProfesor) {
        List<Matricula> todas = matriculaRepository.findAll();

        return todas.stream()
                .filter(m -> m.getCurso().getProfesor().getId().equals(idProfesor))
                .map(m -> new MatriculaDTO(
                        m.getId(),
                        m.getEstudiante().getNombre(),
                        m.getEstudiante().getApellido(),
                        m.getCurso().getNombre(),
                        m.getFechaMatricula()
                ))
                .collect(Collectors.toList());
    }

}
