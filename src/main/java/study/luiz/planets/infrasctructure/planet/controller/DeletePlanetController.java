package study.luiz.planets.infrasctructure.planet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.luiz.planets.entity.planet.exception.PlanetNotFoundException;
import study.luiz.planets.usecase.planet.DeletePlanetUseCase;

@AllArgsConstructor
@RestController
public class DeletePlanetController {

    private final DeletePlanetUseCase deletePlanetUseCase;

    @DeleteMapping("/planets/{id}")
    public ResponseEntity deletePlanet(@PathVariable Long id) throws PlanetNotFoundException {
        return ResponseEntity.ok(deletePlanetUseCase.execute(id));
    }
}
