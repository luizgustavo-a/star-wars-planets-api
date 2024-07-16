package study.luiz.planets.infrasctructure.planet.gateway;

import lombok.AllArgsConstructor;
import study.luiz.planets.entity.planet.gateway.PlanetGateway;
import study.luiz.planets.entity.planet.model.Planet;
import study.luiz.planets.infrasctructure.config.db.repository.PlanetRepository;
import study.luiz.planets.infrasctructure.config.db.schema.PlanetSchema;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PlanetDatabaseGateway implements PlanetGateway {
    private final PlanetRepository planetRepository;

    @Override
    public Planet addPlanet(Planet planet) {
        return planetRepository.save(new PlanetSchema(planet)).toModel();
    }

    @Override
    public List<Planet> listPlanets() {
        return planetRepository.findAll()
                .stream()
                .map(PlanetSchema::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Planet> searchPlanetByName(String name) {
        return planetRepository.findByName(name)
                .map(PlanetSchema::toModel);
    }

    @Override
    public Optional<Planet> searchPlanetById(Long id) {
        return planetRepository.findById(id)
                .map(PlanetSchema::toModel);
    }

    @Override
    public void deletePlanet(Long id) {
        planetRepository.deleteById(id);
    }
}
