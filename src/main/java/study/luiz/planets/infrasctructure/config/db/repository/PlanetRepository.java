package study.luiz.planets.infrasctructure.config.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.luiz.planets.infrasctructure.config.db.schema.PlanetSchema;

import java.util.Optional;

public interface PlanetRepository extends JpaRepository<PlanetSchema, Long> {
    Optional<PlanetSchema> findByName(String name);
}
