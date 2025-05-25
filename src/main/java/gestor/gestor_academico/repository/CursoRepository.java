package gestor.gestor_academico.repository;

import gestor.gestor_academico.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Long> {
    @Query("SELECT c.profesor.nombre, COUNT(c) FROM Curso c GROUP BY c.profesor.nombre")
    List<Object[]> cantidadCursosPorProfesor();
}
