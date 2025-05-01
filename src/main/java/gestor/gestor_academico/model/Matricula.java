package gestor.gestor_academico.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="estudiante_id", referencedColumnName = "id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name="curso_id", referencedColumnName = "id")
    private Curso curso;

    private LocalDate fechaMatricula;

    //Constructor vacio
    public Matricula(){

    }

    //Getter y Setter
    public Long getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
}
