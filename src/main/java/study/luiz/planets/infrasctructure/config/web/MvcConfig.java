package study.luiz.planets.infrasctructure.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.luiz.planets.infrasctructure.config.db.repository.PlanetRepository;
import study.luiz.planets.infrasctructure.planet.gateway.PlanetDatabaseGateway;
import study.luiz.planets.usecase.planet.*;

@Configuration
public class MvcConfig {

    @Bean
    public AddPlanetUseCase addPlanetUseCase(PlanetRepository planetRepository) {
        return new AddPlanetUseCase(new PlanetDatabaseGateway(planetRepository));
    }

    @Bean
    public DeletePlanetUseCase deletePlanetUseCase(PlanetRepository planetRepository) {
        return new DeletePlanetUseCase(new PlanetDatabaseGateway(planetRepository));
    }

    @Bean
    public ListPlanetsUseCase listPlanetsUseCase(PlanetRepository planetRepository) {
        return new ListPlanetsUseCase(new PlanetDatabaseGateway(planetRepository));
    }

    @Bean
    public SearchPlanetByIdUseCase searchPlanetByIdUseCase(PlanetRepository planetRepository) {
        return new SearchPlanetByIdUseCase(new PlanetDatabaseGateway(planetRepository));
    }

    @Bean
    public SearchPlanetByNameUseCase searchPlanetByNameUseCase(PlanetRepository planetRepository) {
        return new SearchPlanetByNameUseCase(new PlanetDatabaseGateway(planetRepository));
    }

}
