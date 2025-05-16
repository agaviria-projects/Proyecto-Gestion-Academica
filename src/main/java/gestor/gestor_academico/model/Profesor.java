package gestor.gestor_academico.model;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String especialidad;
    private String email;

    //Relacion con los cursos que dicta el profesor
    @OneToMany(mappedBy = "profesor", fetch = FetchType.LAZY)
    private List<Curso> cursos;

    //Constructor vacio
    public Profesor(){

    }
    //Getter y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getEmail() {
        return email;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

}

