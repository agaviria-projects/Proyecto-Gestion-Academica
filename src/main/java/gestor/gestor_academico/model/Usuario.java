package gestor.gestor_academico.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;


    private String nombreUsuario;
    private String contrasena;
    private String correo;     // ← Agregado
    private String rol;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasena, String correo, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.rol = rol;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public String getRol() {
        return rol;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
