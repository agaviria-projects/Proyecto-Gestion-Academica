package gestor.gestor_academico.controller;


import gestor.gestor_academico.model.Estudiante;
import gestor.gestor_academico.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante>Listar(){

        return estudianteService.listarEstudiantes();
    }

    @PostMapping
    public Estudiante guardar(@RequestBody Estudiante estudiante){
        return estudianteService.guardarEstudiante(estudiante);
    }

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante){
        return estudianteService.actualizarEstudiante(id, estudiante);
    }

    @GetMapping("/{id}")
    public Estudiante buscar(@PathVariable Long id){
        return estudianteService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id){
        estudianteService.eliminarEstudiante(id);
        }
}
