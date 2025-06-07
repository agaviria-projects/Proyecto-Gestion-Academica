// ✅ UsuarioController.java corregido
package gestor.gestor_academico.controller;

import gestor.gestor_academico.model.Usuario;
import gestor.gestor_academico.model.Profesor;
import gestor.gestor_academico.model.Estudiante;
import gestor.gestor_academico.service.UsuarioService;
import gestor.gestor_academico.service.ProfesorService;
import gestor.gestor_academico.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.obtenerPorId(id);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        // Asociar estudiante si el rol es ESTUDIANTE
        if ("ESTUDIANTE".equalsIgnoreCase(usuario.getRol()) && usuario.getCorreo() != null) {
            Estudiante estudiante = estudianteService.buscarPorCorreo(usuario.getCorreo());
            if (estudiante != null) {
                usuario.setEstudiante(estudiante);
            }
        }

        // Asociar profesor si el rol es PROFESOR
        if ("PROFESOR".equalsIgnoreCase(usuario.getRol()) && usuario.getCorreo() != null) {
            Profesor profesor = profesorService.buscarPorCorreo(usuario.getCorreo());
            if (profesor != null) {
                usuario.setProfesor(profesor);
            }
        }

        return usuarioService.guardar(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> actualizado = usuarioService.actualizar(id, usuario);
        return actualizado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (usuarioService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/total")
    public Long contarUsuarios() {
        return usuarioService.contarUsuarios();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario) {
        Usuario encontrado = usuarioService.buscarPorNombreUsuario(usuario.getNombreUsuario());

        if (encontrado != null && encontrado.getContrasena().equals(usuario.getContrasena())) {
            Map<String, Object> response = new HashMap<>();
            response.put("id", encontrado.getId());
            response.put("nombreUsuario", encontrado.getNombreUsuario());
            response.put("rol", encontrado.getRol());
            response.put("correo", encontrado.getCorreo());
            response.put("profesorId", (encontrado.getProfesor() != null) ? encontrado.getProfesor().getId() : null);
            response.put("estudianteId", (encontrado.getEstudiante() != null) ? encontrado.getEstudiante().getId() : null);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
