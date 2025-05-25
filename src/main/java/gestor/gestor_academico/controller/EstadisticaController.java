package gestor.gestor_academico.controller;

import gestor.gestor_academico.dto.EstudiantesPorCursoDTO;
import gestor.gestor_academico.dto.PromedioPorCursoDTO;
import gestor.gestor_academico.repository.MatriculaRepository;
import gestor.gestor_academico.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticaController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private NotaRepository notaRepository;

    @GetMapping("/estudiantes-por-curso")
    public List<EstudiantesPorCursoDTO> estudiantesPorCurso() {
        return matriculaRepository.cantidadEstudiantesPorCurso();
    }

    @GetMapping("/promedios-por-curso")
    public List<PromedioPorCursoDTO> promediosNotas() {
        return notaRepository.promediosPorCurso();
    }
}
