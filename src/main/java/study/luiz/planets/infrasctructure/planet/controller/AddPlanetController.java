package study.luiz.planets.infrasctructure.planet.controller;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import study.luiz.planets.infrasctructure.planet.dto.PlanetPublicData;
import study.luiz.planets.infrasctructure.planet.dto.PlanetRegistrationData;
import study.luiz.planets.usecase.planet.AddPlanetUseCase;

@AllArgsConstructor
@RestController
public class AddPlanetController {

    private final AddPlanetUseCase addPlanetUseCase;

    @PostMapping("/planets")
    public ResponseEntity<Object> addPlanet(@RequestBody @Valid PlanetRegistrationData data,
                                                      UriComponentsBuilder builder) {

        var planet = new PlanetPublicData(addPlanetUseCase.execute(data));
        var uri = builder.path("/planets/{id}").buildAndExpand(planet.id()).toUri();

        return ResponseEntity.created(uri).body(planet);
    }
}
