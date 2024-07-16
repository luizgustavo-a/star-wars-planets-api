package study.luiz.planets.infrasctructure.planet.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.luiz.planets.infrasctructure.planet.dto.PlanetPublicData;
import study.luiz.planets.usecase.planet.ListPlanetsUseCase;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class ListPlanetsController {

    private final ListPlanetsUseCase listPlanetsUseCase;

    @GetMapping("/planets")
    public ResponseEntity<List<PlanetPublicData>> listPlanets() {
        return ResponseEntity.ok(listPlanetsUseCase.execute()
                .stream()
                .map(PlanetPublicData::new)
                .collect(Collectors.toList()));
    }
}
