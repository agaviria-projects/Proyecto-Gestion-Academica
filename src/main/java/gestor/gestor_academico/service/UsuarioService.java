package gestor.gestor_academico.service;

import gestor.gestor_academico.model.Usuario;
import gestor.gestor_academico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> login(String nombreUsuario, String contrasena, String rol) {
        return usuarioRepository.findByNombreUsuarioAndContrasenaAndRol(nombreUsuario, contrasena, rol);
    }
}

