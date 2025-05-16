package gestor.gestor_academico.repository;

import gestor.gestor_academico.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository <Nota, Long>{
}
