package gestor.gestor_academico.controller;

import gestor.gestor_academico.model.Usuario;
import gestor.gestor_academico.service.UsuarioService;
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
            // Construir respuesta personalizada
            Map<String, Object> response = new HashMap<>();
            response.put("id", encontrado.getId());
            response.put("nombreUsuario", encontrado.getNombreUsuario());
            response.put("rol", encontrado.getRol());
            response.put("correo", encontrado.getCorreo());

            // Si el usuario es profesor, incluir el id del profesor asociado
            if ("PROFESOR".equalsIgnoreCase(encontrado.getRol()) && encontrado.getProfesor() != null) {
                response.put("profesorId", encontrado.getProfesor().getId());
            }

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }



}
