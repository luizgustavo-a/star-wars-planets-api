package study.luiz.planets.entity.planet.gateway;

import study.luiz.planets.entity.planet.model.Planet;

import java.util.List;
import java.util.Optional;

public interface PlanetGateway {
    Planet addPlanet(Planet planet);

    List<Planet> listPlanets();

    Optional<Planet> searchPlanetByName(String name);
    Optional<Planet> searchPlanetById(Long id);

    void deletePlanet(Long id);
}
