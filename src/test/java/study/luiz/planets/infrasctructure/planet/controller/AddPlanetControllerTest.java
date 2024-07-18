package study.luiz.planets.infrasctructure.planet.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import study.luiz.planets.entity.planet.model.Planet;
import study.luiz.planets.infrasctructure.config.db.repository.PlanetRepository;
import study.luiz.planets.infrasctructure.planet.dto.PlanetRegistrationData;
import study.luiz.planets.usecase.planet.AddPlanetUseCase;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddPlanetController.class)
@AutoConfigureMockMvc
class AddPlanetControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AddPlanetUseCase addPlanetUseCase;

    @MockBean
    private PlanetRepository repository;

    @Test
    void shouldBeCreatedSolicitationSuccessful() throws Exception {
        String json = """
                {
                  "name": "Tatooine",
                  "climate": "arid",
                  "terrain": "desert"
                }
                """;

        var planet = new PlanetRegistrationData("Tatooine","arid","desert");
        when(addPlanetUseCase.execute(planet)).thenReturn(new Planet());
        mvc.perform(
                post("/planets")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated());
    }

    @Test
    void shouldBeBadRequestIncompleteSolicitation() throws Exception {
        String json = """
                {}
                """;

        mvc.perform(
                post("/planets")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isBadRequest());
    }

}