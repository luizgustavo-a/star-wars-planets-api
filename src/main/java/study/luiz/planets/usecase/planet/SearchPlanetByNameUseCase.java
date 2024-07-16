package study.luiz.planets.usecase.planet;

import lombok.AllArgsConstructor;
import study.luiz.planets.entity.planet.exception.PlanetNotFoundException;
import study.luiz.planets.entity.planet.gateway.PlanetGateway;
import study.luiz.planets.entity.planet.model.Planet;

@AllArgsConstructor
public class SearchPlanetByNameUseCase {
    private final PlanetGateway planetGateway;

    public Planet execute(String name) throws PlanetNotFoundException {
        return planetGateway
                .searchPlanetByName(name)
                .orElseThrow(PlanetNotFoundException::new);
    }
}
