package gestor.gestor_academico.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    // Relación con Profesor
    @ManyToOne
    @JoinColumn(name = "profesor_id",referencedColumnName = "id")
    private Profesor profesor;

    //Relación con Estudiante
    @OneToMany(mappedBy = "curso",fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;

    //Constructor vacio
    public Curso(){

    }

    //Getter y Setters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Profesor getProfesor(){ return profesor;}

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
