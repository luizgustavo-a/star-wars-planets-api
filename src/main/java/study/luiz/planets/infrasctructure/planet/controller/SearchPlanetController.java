package study.luiz.planets.infrasctructure.planet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.luiz.planets.entity.planet.exception.PlanetNotFoundException;
import study.luiz.planets.infrasctructure.planet.dto.PlanetPublicData;
import study.luiz.planets.usecase.planet.SearchPlanetByIdUseCase;
import study.luiz.planets.usecase.planet.SearchPlanetByNameUseCase;

@AllArgsConstructor
@RestController
public class SearchPlanetController {

    private final SearchPlanetByIdUseCase searchPlanetByIdUseCase;
    private final SearchPlanetByNameUseCase searchPlanetByNameUseCase;

    @GetMapping("/planets?search={idOrName}")
    public ResponseEntity<PlanetPublicData> searchPlanet (@PathVariable String idOrName)
            throws PlanetNotFoundException {

        try {
            return ResponseEntity.ok(
                    new PlanetPublicData(searchPlanetByIdUseCase.execute(Long.parseLong(idOrName)))
            );
        } catch (NumberFormatException e) {
            // Verify if the input is a long, meaning it is an id
        }

        return ResponseEntity.ok(
                new PlanetPublicData(searchPlanetByNameUseCase.execute(idOrName))
        );
    }
}
