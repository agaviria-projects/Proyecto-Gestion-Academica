package gestor.gestor_academico.controller;

import gestor.gestor_academico.dto.CursoDTO;
import gestor.gestor_academico.model.Curso;
import gestor.gestor_academico.repository.CursoRepository;
import gestor.gestor_academico.service.CursoService;
import gestor.gestor_academico.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private CursoRepository cursoRepository;

    // Listar todos los cursos

    @GetMapping("/cantidad-por-profesor")
    public List<Map<String, Object>> cursosPorProfesor() {
        List<Object[]> resultados = cursoRepository.cantidadCursosPorProfesor();
        List<Map<String, Object>> respuesta = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> map = new HashMap<>();
            map.put("profesor", fila[0]);
            map.put("cantidad", fila[1]);
            respuesta.add(map);
        }
        return respuesta;
    }
    // Obtener lista de cursos con nombre del profesor (y filtrado por profesorId si se desea)
    @GetMapping("/dto")
    public List<CursoDTO> obtenerCursosDTO(@RequestParam(required = false) Long profesorId) {
        List<Curso> cursos = cursoRepository.findAll();

        if (profesorId != null) {
            cursos = cursos.stream()
                    .filter(c -> c.getProfesor() != null && c.getProfesor().getId().equals(profesorId))
                    .toList();
        }

        return cursos.stream().map(c -> {
            CursoDTO dto = new CursoDTO();
            dto.setId(c.getId());
            dto.setNombre(c.getNombre());
            dto.setDescripcion(c.getDescripcion());

            if (c.getProfesor() != null) {
                dto.setNombreProfesor(c.getProfesor().getNombre());
                dto.setProfesorId(c.getProfesor().getId());
            }

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
