package gestor.gestor_academico.repository;

import gestor.gestor_academico.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Busca un usuario que coincida exactamente con nombreUsuario, contraseña y rol.
    // Esta consulta se usa para validar el login del sistema.
    // Devuelve un Optional<Usuario> que estará presente si las credenciales son correctas.
    Optional<Usuario> findByNombreUsuarioAndContrasenaAndRol(String nombreUsuario, String contrasena, String rol);
}
