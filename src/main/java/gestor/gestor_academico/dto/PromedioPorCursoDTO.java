package gestor.gestor_academico.dto;

public class PromedioPorCursoDTO {
    private String curso;
    private Double promedio;

    public PromedioPorCursoDTO(String curso, Double promedio) {
        this.curso = curso;
        this.promedio = promedio;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }
}
