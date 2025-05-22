package gestor.gestor_academico.service;

import gestor.gestor_academico.model.Curso;
import gestor.gestor_academico.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos(){
        return cursoRepository.findAll();
    }
    public Curso guardarCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    public Curso buscarPorId(Long id){
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso actualizarCurso(Long id, Curso curso) {
        if (cursoRepository.existsById(id)) {
            curso.setId(id);
            return cursoRepository.save(curso);
        }
        return null;
    }

    public Long contarCursos(){
        return cursoRepository.count();
    }


    public void eliminarCurso(Long id){
        cursoRepository.deleteById(id);
    }
}




