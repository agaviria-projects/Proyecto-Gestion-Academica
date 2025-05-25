package gestor.gestor_academico.repository;

import gestor.gestor_academico.model.Matricula;
import gestor.gestor_academico.dto.EstudiantesPorCursoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @Query("SELECT new gestor.gestor_academico.dto.EstudiantesPorCursoDTO(m.curso.nombre, COUNT(m.id)) " +
            "FROM Matricula m GROUP BY m.curso.nombre")
    List<EstudiantesPorCursoDTO> cantidadEstudiantesPorCurso();
}
