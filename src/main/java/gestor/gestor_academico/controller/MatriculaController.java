package gestor.gestor_academico.controller;

import gestor.gestor_academico.model.Matricula;
import gestor.gestor_academico.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public List<Matricula>Listar(){
        return matriculaService.listarMatriculas();
    }

    @GetMapping("/{id}")
    public Matricula buscar(@PathVariable Long id){
        return matriculaService.buscarPorId(id);
    }

    @PostMapping
    public Matricula guardar(@RequestBody Matricula matricula){
        return matriculaService.guardarMatricula(matricula);
    }
    @PutMapping("/{id}")
    public Matricula actualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula){
        return matriculaService.actualizarMatricula(id,matricula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        matriculaService.eliminarMatricula(id);
    }
}
