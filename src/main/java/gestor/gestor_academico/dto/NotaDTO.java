package gestor.gestor_academico.dto;

import java.time.LocalDate;

public class NotaDTO {
    private Long id;
    private Double nota;
    private LocalDate fechaNota;
    private String nombreEstudiante;
    private String apellidoEstudiante;
    private String nombreCurso;

    public Long getId() {
        return id;
    }

    public Double getNota() {
        return nota;
    }

    public LocalDate getFechaNota() {
        return fechaNota;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setFechaNota(LocalDate fechaNota) {
        this.fechaNota = fechaNota;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}

