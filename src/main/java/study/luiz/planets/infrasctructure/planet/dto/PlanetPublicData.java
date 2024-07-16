package study.luiz.planets.infrasctructure.planet.dto;

import study.luiz.planets.entity.planet.model.Planet;
import study.luiz.planets.usecase.planet.dto.IPlanetPublicData;

public record PlanetPublicData (
        Long id,
        String name,
        String climate,
        String terrain,
        Integer numberApparitions
) implements IPlanetPublicData {
    public PlanetPublicData (Planet planet) {
        this(planet.getId(), planet.getName(), planet.getClimate(),
                planet.getTerrain(), planet.getNumberApparitions());
    }
}
