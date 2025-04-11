package gestor.gestor_academico.model;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import java.util.List;


import java.awt.*;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nombre;
    private String especialidad;

    //Relacion con los cursos que dicta el profesor
    @OneToMany(mappedBy = "profesor", cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Curso> cursos;

    //Getter y Setters

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
