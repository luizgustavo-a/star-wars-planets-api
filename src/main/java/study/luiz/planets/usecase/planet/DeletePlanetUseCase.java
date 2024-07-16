package study.luiz.planets.usecase.planet;

import lombok.AllArgsConstructor;
import study.luiz.planets.entity.planet.exception.PlanetNotFoundException;
import study.luiz.planets.entity.planet.gateway.PlanetGateway;
import study.luiz.planets.entity.planet.model.Planet;

@AllArgsConstructor
public class DeletePlanetUseCase {
    private final PlanetGateway planetGateway;

    public Planet execute(Long id) throws PlanetNotFoundException {
        Planet planet = planetGateway.searchPlanetById(id)
                .orElseThrow(PlanetNotFoundException::new);

        planetGateway.deletePlanet(id);

        return planet;
    }
}
