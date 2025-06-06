package gestor.gestor_academico.controller;

import gestor.gestor_academico.dto.ProfesorDTO;
import gestor.gestor_academico.model.Profesor;
import gestor.gestor_academico.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    // Guardar un nuevo profesor
    @PostMapping
    public Profesor guardar(@RequestBody Profesor profesor) {
        return profesorService.guardarProfesor(profesor);
    }

    // Actualizar profesor por ID
    @PutMapping("/{id}")
    public Profesor actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        return profesorService.actualizarProfesor(id, profesor);
    }

    // Buscar profesor por ID
    @GetMapping("/{id}")
    public Profesor buscar(@PathVariable Long id) {
        return profesorService.buscarPorId(id);
    }

    // Eliminar profesor por ID
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
    }

    @GetMapping("/total")
    public Long contarProfesores() {
        return profesorService.contarProfesores();
    }

    @GetMapping("/dto")
    public List<ProfesorDTO> listarProfesoresDTO() {
        return profesorService.obtenerTodosDTO();
    }
    @GetMapping
    public List<Profesor> obtenerTodos() {
        return profesorService.listarProfesores();
    }

}
