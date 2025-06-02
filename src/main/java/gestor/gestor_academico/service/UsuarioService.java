package gestor.gestor_academico.service;

import gestor.gestor_academico.model.Usuario;
import gestor.gestor_academico.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> actualizar(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombreUsuario(usuario.getNombreUsuario());
            u.setContrasena(usuario.getContrasena());
            u.setCorreo(usuario.getCorreo());
            u.setRol(usuario.getRol());
            return usuarioRepository.save(u);
        });
    }

    public boolean eliminar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Long contarUsuarios(){
        return usuarioRepository.count();
    }

    public Optional<Usuario> login(String nombreUsuario, String contrasena) {
        return usuarioRepository.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
    }

    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

}
