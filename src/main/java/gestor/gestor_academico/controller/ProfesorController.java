package gestor.gestor_academico.controller;


import gestor.gestor_academico.model.Estudiante;
import gestor.gestor_academico.model.Profesor;
import gestor.gestor_academico.service.ProfesorService;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor>Listar(){
        return profesorService.listarProfesores();
    }
    @PostMapping
    public Profesor guardar(@RequestBody Profesor profesor){
        return profesorService.guardarProfesor(profesor);
    }
    @GetMapping("/{id}")
    public Profesor buscar(@PathVariable Long id){
        return profesorService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        profesorService.eliminarProfesor(id);
    }


}
