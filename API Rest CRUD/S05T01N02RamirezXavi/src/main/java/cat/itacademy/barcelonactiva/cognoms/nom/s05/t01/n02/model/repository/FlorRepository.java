package cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlorRepository extends JpaRepository<FlorEntity, Long> {
}
