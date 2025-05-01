package gestor.gestor_academico.controller;

import gestor.gestor_academico.model.Curso;
import gestor.gestor_academico.service.CursoService;
import gestor.gestor_academico.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfesorService profesorService;

    // Listar todos los cursos
    @GetMapping
    public List<Curso> Listar() {
        return cursoService.listarCursos();
    }

    // Guardar un nuevo curso
    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        if (curso.getProfesor() != null && curso.getProfesor().getId() != null) {
            curso.setProfesor(profesorService.buscarPorId(curso.getProfesor().getId()));
        }
        return cursoService.guardarCurso(curso);
    }

    // Buscar curso por ID
    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    // Actualizar curso por ID
    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        if (curso.getProfesor() != null && curso.getProfesor().getId() != null) {
            curso.setProfesor(profesorService.buscarPorId(curso.getProfesor().getId()));
        }
        return cursoService.actualizarCurso(id, curso);
    }

    // Eliminar curso por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}
