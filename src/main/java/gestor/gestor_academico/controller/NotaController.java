package gestor.gestor_academico.controller;

import gestor.gestor_academico.model.Nota;
import gestor.gestor_academico.service.NotaService;
import gestor.gestor_academico.service.CursoService;
import gestor.gestor_academico.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
public class  NotaController {

    @Autowired
    private NotaService notaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService cursoService;

    // Listar todas las notas
    @GetMapping
    public List<Nota> listar() {
        return notaService.obtenerTodasLasNotas();
    }

    // Guardar una nueva nota
    @PostMapping
    public Nota guardar(@RequestBody Nota nota) {
        if (nota.getEstudiante() != null && nota.getEstudiante().getId() != null) {
            nota.setEstudiante(estudianteService.buscarPorId(nota.getEstudiante().getId()));
        }
        if (nota.getCurso() != null && nota.getCurso().getId() != null) {
            nota.setCurso(cursoService.buscarPorId(nota.getCurso().getId()));
        }
        return notaService.guardarNota(nota);
    }

    // Buscar nota por ID
    @GetMapping("/{id}")
    public Nota buscar(@PathVariable Long id) {
        return notaService.obtenerNotaPorId(id).orElse(null);
    }

    // Actualizar una nota por ID
    @PutMapping("/{id}")
    public Nota actualizar(@PathVariable Long id, @RequestBody Nota nota) {
        if (nota.getEstudiante() != null && nota.getEstudiante().getId() != null) {
            nota.setEstudiante(estudianteService.buscarPorId(nota.getEstudiante().getId()));
        }
        if (nota.getCurso() != null && nota.getCurso().getId() != null) {
            nota.setCurso(cursoService.buscarPorId(nota.getCurso().getId()));
        }
        nota.setId(id);
        return notaService.guardarNota(nota);
    }

    // Eliminar una nota por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notaService.eliminarNota(id);
    }

    @GetMapping("/total")
    public Long contarNotas() {
        return notaService.contarNotas();
    }

}
