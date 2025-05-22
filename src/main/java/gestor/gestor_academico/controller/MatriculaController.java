package gestor.gestor_academico.controller;

import gestor.gestor_academico.model.Matricula;
import gestor.gestor_academico.service.MatriculaService;
import gestor.gestor_academico.service.CursoService;
import gestor.gestor_academico.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Matricula> Listar() {
        return matriculaService.listarMatriculas();
    }

    // Buscar matrícula por ID
    @GetMapping("/{id}")
    public Matricula buscar(@PathVariable Long id) {
        return matriculaService.buscarPorId(id);
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

}

