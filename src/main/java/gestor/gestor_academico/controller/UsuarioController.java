package gestor.gestor_academico.controller;


import gestor.gestor_academico.model.Usuario;
import gestor.gestor_academico.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public Optional<Usuario> login(@RequestBody Usuario usuario){
        return usuarioService.login(usuario.getNombreUsuario(),usuario.getContrasena(),usuario.getRol());
    }
}
