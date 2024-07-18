package study.luiz.planets.infrasctructure.planet.dto;

import jakarta.validation.constraints.NotBlank;
import study.luiz.planets.usecase.planet.dto.IPlanetRegistrationData;

public record PlanetRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        String climate,
        @NotBlank
        String terrain
) implements IPlanetRegistrationData {
}
