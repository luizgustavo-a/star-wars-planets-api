package study.luiz.planets.infrasctructure.planet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/planets", params = "search")
    public ResponseEntity<PlanetPublicData> searchPlanet (@RequestParam String search) throws PlanetNotFoundException {
        try {
            return ResponseEntity.ok(
                    new PlanetPublicData(searchPlanetByIdUseCase.execute(Long.parseLong(search)))
            );
        } catch (NumberFormatException e) {
            // Verify if the input is a long, meaning it is an id
        }

        return ResponseEntity.ok(
                new PlanetPublicData(searchPlanetByNameUseCase.execute(search))
        );
    }
}
