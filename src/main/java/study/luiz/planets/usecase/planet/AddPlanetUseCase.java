package study.luiz.planets.usecase.planet;

import lombok.AllArgsConstructor;
import study.luiz.planets.entity.planet.gateway.PlanetGateway;
import study.luiz.planets.entity.planet.model.Planet;
import study.luiz.planets.usecase.planet.dto.IPlanetRegistrationData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class AddPlanetUseCase {

    private final PlanetGateway planetGateway;

    public Planet execute(IPlanetRegistrationData data) {
        Planet planet = new Planet(data.name(), data.climate(), data.terrain(), numberApparitions(data.name()));

        return planetGateway.addPlanet(planet);
    }

    public Integer numberApparitions(String name) {
        final String SEARCH_PLANET_API = "https://swapi.dev/api/planets/?search=";
        int number = 0;
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(
                    HttpRequest.newBuilder().uri(URI.create(SEARCH_PLANET_API+name)).build(),
                    HttpResponse.BodyHandlers.ofString()
            );
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(response != null) {
            List<String> films = Arrays.stream(response.body().split("\"")).filter(e -> e.contains("https://swapi.dev/api/films/"))
                    .collect(Collectors.toList());
            number = films.size();
        }

        return number;
    }
}
