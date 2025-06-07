package gestor.gestor_academico.repository;

import gestor.gestor_academico.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
    Optional<Profesor> findByEmail(String email);

}
