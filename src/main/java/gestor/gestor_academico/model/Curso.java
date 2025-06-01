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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profesor_id",referencedColumnName = "id")
    @JsonIgnoreProperties("cursos")
    private Profesor profesor;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return id != null && id.equals(curso.id);
    }

    @Override
    public int hashCode() {
        return 31; // puedes usar Objects.hash(id) si usas Java 7+
    }
}
