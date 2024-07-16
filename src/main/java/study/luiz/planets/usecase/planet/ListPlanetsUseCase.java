package study.luiz.planets.usecase.planet;

import lombok.AllArgsConstructor;
import study.luiz.planets.entity.planet.gateway.PlanetGateway;
import study.luiz.planets.entity.planet.model.Planet;

import java.util.List;

@AllArgsConstructor
public class ListPlanetsUseCase {
    private final PlanetGateway planetGateway;

    public List<Planet> execute() {
        return planetGateway.listPlanets();
    }
}
