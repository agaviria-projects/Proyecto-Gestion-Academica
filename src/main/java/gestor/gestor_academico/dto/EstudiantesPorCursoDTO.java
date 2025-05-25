package gestor.gestor_academico.dto;

public class EstudiantesPorCursoDTO {
    private String curso;
    private Long cantidad;

    public EstudiantesPorCursoDTO(String curso, Long cantidad) {
        this.curso = curso;
        this.cantidad = cantidad;
    }

    public String getCurso() {
        return curso;
    }

    public Long getCantidad() {
        return cantidad;
    }
}

