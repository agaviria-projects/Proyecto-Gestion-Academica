package gestor.gestor_academico.service;


import gestor.gestor_academico.model.Nota;
import gestor.gestor_academico.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    //Obtener todas las notas
    public List<Nota> obtenerTodasLasNotas(){
        return notaRepository.findAll();
    }
    // Obtener una nota por ID
    public Optional<Nota>obtenerNotaPorId(Long id){
        return notaRepository.findById(id);
    }

    //Guardar o actualizar una nota
    public Nota guardarNota(Nota nota){
        return notaRepository.save(nota);
    }

    public Long contarNotas(){
        return notaRepository.count();
    }

    public boolean existePorId(Long id) {
        return notaRepository.existsById(id);
    }

    //Eliminar una nota por Id
    public void eliminarNota(Long id){
        notaRepository.deleteById(id);
    }
}
