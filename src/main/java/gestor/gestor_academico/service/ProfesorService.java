package gestor.gestor_academico.service;


import gestor.gestor_academico.model.Estudiante;
import gestor.gestor_academico.model.Profesor;
import gestor.gestor_academico.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void eliminarProfesor(Long id){
        profesorRepository.deleteById(id);
    }
}

