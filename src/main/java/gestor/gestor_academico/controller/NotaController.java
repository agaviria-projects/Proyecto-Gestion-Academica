package gestor.gestor_academico.controller;

import gestor.gestor_academico.dto.NotaDTO;
import gestor.gestor_academico.dto.NotaInputDTO;
import gestor.gestor_academico.model.Nota;
import gestor.gestor_academico.repository.NotaRepository;
import gestor.gestor_academico.service.NotaService;
import gestor.gestor_academico.service.CursoService;
import gestor.gestor_academico.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
public class  NotaController {

    @Autowired
    private NotaService notaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private CursoService cursoService;

    // Listar todas las notas
    @GetMapping
    public List<Nota> listar() {
        return notaService.obtenerTodasLasNotas();
    }

    // Guardar una nueva nota
    @PostMapping
    public Nota guardar(@RequestBody NotaInputDTO dto) {
        Nota nota = new Nota();
        nota.setNota(dto.getNota());
        nota.setFechaNota(dto.getFechaNota());

        if (dto.getEstudianteId() != null) {
            nota.setEstudiante(estudianteService.buscarPorId(dto.getEstudianteId()));
        }

        if (dto.getCursoId() != null) {
            nota.setCurso(cursoService.buscarPorId(dto.getCursoId()));
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
    public Nota actualizar(@PathVariable Long id, @RequestBody NotaInputDTO dto) {
        Nota nota = new Nota();
        nota.setId(id);
        nota.setNota(dto.getNota());
        nota.setFechaNota(dto.getFechaNota());

        if (dto.getEstudianteId() != null) {
            nota.setEstudiante(estudianteService.buscarPorId(dto.getEstudianteId()));
        }

        if (dto.getCursoId() != null) {
            nota.setCurso(cursoService.buscarPorId(dto.getCursoId()));
        }

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
    @GetMapping("/dto")
    public List<NotaDTO> obtenerNotasConNombres() {
        List<Nota> notas = notaRepository.findAll();

        return notas.stream().map(n -> {
            NotaDTO dto = new NotaDTO();
            dto.setId(n.getId());
            dto.setNota(n.getNota());
            dto.setFechaNota(n.getFechaNota());
            dto.setNombreEstudiante(n.getEstudiante().getNombre());
            dto.setApellidoEstudiante(n.getEstudiante().getApellido());
            dto.setNombreCurso(n.getCurso().getNombre());
            return dto;
        }).collect(Collectors.toList());
    }


}
