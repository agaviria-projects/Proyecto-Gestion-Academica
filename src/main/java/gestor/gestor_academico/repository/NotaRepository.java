package gestor.gestor_academico.repository;

import gestor.gestor_academico.model.Nota;
import gestor.gestor_academico.dto.PromedioPorCursoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    @Query("SELECT new gestor.gestor_academico.dto.PromedioPorCursoDTO(n.curso.nombre, AVG(n.nota)) " +
            "FROM Nota n GROUP BY n.curso.nombre")
    List<PromedioPorCursoDTO> promediosPorCurso();

    List<Nota> findByEstudianteEmail(String email);

    @Query("SELECT n FROM Nota n WHERE n.curso.profesor.email = :email")
    List<Nota> findByProfesorEmail(@Param("email") String email);

}
