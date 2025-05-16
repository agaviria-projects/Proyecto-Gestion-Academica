package gestor.gestor_academico.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nota;
    private LocalDate fechaNota;

    @ManyToOne
    @JoinColumn(name ="estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name ="curso_id")
    private Curso curso;

    // Constructor vacío
    public Nota() {
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public Double getNota() {
        return nota;
    }

    public LocalDate getFechaNota() {
        return fechaNota;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setFechaNota(LocalDate fechaNota) {
        this.fechaNota = fechaNota;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
