package gestor.gestor_academico.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombreUsuario;
    private String contrasena;
    private String rol; //admin, estudiante, profesor

    public Usuario(){

    }
    // Constructor adicional con argumentos
    // Se utiliza para crear objetos Usuario rápidamente desde código Java,
    // por ejemplo al insertar datos de prueba sin usar Postman o React.
    // No es obligatorio para el funcionamiento del sistema, pero es útil en pruebas.

    public Usuario(String nombreUsuario,String contrasena, String rol){
        this.nombreUsuario=nombreUsuario;
        this.contrasena=contrasena;
        this.rol=rol;
    }
    // Getters y setters


    public Long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
