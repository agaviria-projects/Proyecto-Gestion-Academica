package gestor.gestor_academico.model;


import jakarta.persistence.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;

    //Relación con Curso
    @ManyToOne
    @JoinColumn(name ="curso_id", referencedColumnName = "id") //nombre de la columna FK en la tabla estudiante
    private Curso curso;

    //Getter y Setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
