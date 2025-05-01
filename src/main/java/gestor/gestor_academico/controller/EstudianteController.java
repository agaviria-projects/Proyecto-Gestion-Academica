package gestor.gestor_academico.controller;

import gestor.gestor_academico.model.Estudiante;
import gestor.gestor_academico.service.EstudianteService;
import gestor.gestor_academico.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService cursoService;

    // Listar todos los estudiantes
    @GetMapping
    public List<Estudiante> Listar() {
        return estudianteService.listarEstudiantes();
    }

    // Guardar nuevo estudiante
    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante) {
        if (estudiante.getCurso() != null && estudiante.getCurso().getId() != null) {
            estudiante.setCurso(cursoService.buscarPorId(estudiante.getCurso().getId()));
        }
        return estudianteService.guardarEstudiante(estudiante);
    }

    // Actualizar estudiante por ID
    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        if (estudiante.getCurso() != null && estudiante.getCurso().getId() != null) {
            estudiante.setCurso(cursoService.buscarPorId(estudiante.getCurso().getId()));
        }
        return estudianteService.actualizarEstudiante(id, estudiante);
    }

    // Buscar estudiante por ID
    @GetMapping("/{id}")
    public Estudiante buscar(@PathVariable Long id) {
        return estudianteService.buscarPorId(id);
    }

    // Eliminar estudiante por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
    }
}
