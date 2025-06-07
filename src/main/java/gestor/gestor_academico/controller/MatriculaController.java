package gestor.gestor_academico.controller;

import gestor.gestor_academico.dto.MatriculaDTO;
import gestor.gestor_academico.model.Curso;
import gestor.gestor_academico.model.Matricula;
import gestor.gestor_academico.service.MatriculaService;
import gestor.gestor_academico.service.CursoService;
import gestor.gestor_academico.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudianteService estudianteService;

    // Listar todas las matrículas

    @GetMapping
    public List<MatriculaDTO> listar() {
        return matriculaService.listarMatriculas().stream()
                .map(m -> new MatriculaDTO(
                        m.getId(),
                        m.getEstudiante().getNombre(),
                        m.getEstudiante().getApellido(),
                        m.getCurso().getNombre(),
                        m.getFechaMatricula()))
                .collect(Collectors.toList());
    }
    // Buscar matrícula por ID
    @GetMapping("/{id}")
    public Matricula buscar(@PathVariable Long id) {
        return matriculaService.buscarPorId(id);
    }

    @GetMapping("/estudiante/{id}")
    public List<Matricula> listarPorEstudiante(@PathVariable Long id) {
        return matriculaService.listarPorEstudiante(id);
    }

    // Guardar una nueva matrícula
    @PostMapping
    public Matricula guardar(@RequestBody Matricula matricula) {
        if (matricula.getCurso() != null && matricula.getCurso().getId() != null) {
            matricula.setCurso(cursoService.buscarPorId(matricula.getCurso().getId()));
        }
        if (matricula.getEstudiante() != null && matricula.getEstudiante().getId() != null) {
            matricula.setEstudiante(estudianteService.buscarPorId(matricula.getEstudiante().getId()));
        }
        return matriculaService.guardarMatricula(matricula);
    }

    // Actualizar matrícula existente
    @PutMapping("/{id}")
    public Matricula actualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
        if (matricula.getCurso() != null && matricula.getCurso().getId() != null) {
            matricula.setCurso(cursoService.buscarPorId(matricula.getCurso().getId()));
        }
        if (matricula.getEstudiante() != null && matricula.getEstudiante().getId() != null) {
            matricula.setEstudiante(estudianteService.buscarPorId(matricula.getEstudiante().getId()));
        }
        return matriculaService.actualizarMatricula(id, matricula);
    }

    // Eliminar matrícula por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        matriculaService.eliminarMatricula(id);
    }
    @GetMapping("/total")
    public Long contarMatriculas() {
        return matriculaService.contarMatriculas();
    }

    @GetMapping("/estudiante/{id}/cursos")
    public List<Curso> cursosDeEstudiante(@PathVariable Long id) {
        return matriculaService.listarPorEstudiante(id)
                .stream()
                .map(Matricula::getCurso)
                .distinct() // evita cursos duplicados si está matriculado varias veces al mismo
                .collect(Collectors.toList());
    }
    @GetMapping("/profesor/{idProfesor}")
    public List<MatriculaDTO> obtenerMatriculasPorProfesor(@PathVariable Long idProfesor) {
        return matriculaService.obtenerMatriculasPorProfesor(idProfesor);
    }



}

