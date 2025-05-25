package gestor.gestor_academico.dto;

import java.time.LocalDate;

public class NotaInputDTO {
    private Long id;
    private Double nota;
    private LocalDate fechaNota;
    private Long estudianteId;
    private Long cursoId;

    public NotaInputDTO() {}

    public Long getId() {
        return id;
    }

    public Double getNota() {
        return nota;
    }

    public LocalDate getFechaNota() {
        return fechaNota;
    }

    public Long getEstudianteId() {
        return estudianteId;
    }

    public Long getCursoId() {
        return cursoId;
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

    public void setEstudianteId(Long estudianteId) {
        this.estudianteId = estudianteId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }
}
