package study.luiz.planets.infrasctructure.planet.dto;

import study.luiz.planets.usecase.planet.dto.IPlanetRegistrationData;

public record PlanetRegistrationData(
        String name,
        String climate,
        String terrain,
        Integer numberApparitions
) implements IPlanetRegistrationData {
}
