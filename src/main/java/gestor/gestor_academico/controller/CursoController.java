package gestor.gestor_academico.controller;


import gestor.gestor_academico.model.Curso;
import gestor.gestor_academico.model.Estudiante;
import gestor.gestor_academico.service.CursoService;
import gestor.gestor_academico.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> Listar(){
        return cursoService.listarCursos();
    }

    @PostMapping
    public Curso guardar(@RequestBody Curso curso){
        return cursoService.guardarCurso(curso);
    }

    @GetMapping("/{id}")
    public Curso buscar(@PathVariable Long id){
        return cursoService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        cursoService.eliminarCurso(id);
    }
}

