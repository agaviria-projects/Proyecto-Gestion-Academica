package gestor.gestor_academico.controller;

import gestor.gestor_academico.dto.CursoDTO;
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
    @GetMapping("/dto")
    public List<CursoDTO> obtenerCursosConProfesor() {
        List<Curso> cursos = cursoService.listarCursos();
        return cursos.stream().map(curso -> {
            CursoDTO dto = new CursoDTO();
            dto.setId(curso.getId());
            dto.setNombre(curso.getNombre());
            dto.setDescripcion(curso.getDescripcion());
            dto.setNombreProfesor(
                    (curso.getProfesor() != null && curso.getProfesor().getNombre() != null)
                            ? curso.getProfesor().getNombre()
                            : "Sin asignar"
            );
            return dto;
        }).toList();
    }


    // Guardar un nuevo curso
    @PostMapping
    public Curso guardar(@RequestBody Curso curso) {
        if (curso.getProfesor() != null && curso.getProfesor().getId() != null) {
            curso.setProfesor(profesorService.buscarPorId(curso.getProfesor().getId()));
        }
        return cursoService.guardarCurso(curso);
    }

    @GetMapping("/total")
    public Long contarCursos() {
        return cursoService.contarCursos();
    }

    // Buscar curso por ID
    @GetMapping("/buscar/{id}")
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
