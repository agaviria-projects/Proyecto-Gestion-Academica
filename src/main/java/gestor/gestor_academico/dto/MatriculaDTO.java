package gestor.gestor_academico.dto;

import java.time.LocalDate;

public class MatriculaDTO {
    private Long id;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String nombreCurso;
    private LocalDate fechaMatricula;

    public MatriculaDTO(Long id, String nombreEstudiante, String apellidoEstudiante, String nombreCurso, LocalDate fechaMatricula) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.nombreCurso = nombreCurso;
        this.fechaMatricula = fechaMatricula;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }
}

