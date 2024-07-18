package study.luiz.planets.infrasctructure.planet.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import study.luiz.planets.entity.planet.exception.PlanetNotFoundException;
import study.luiz.planets.entity.planet.model.Planet;
import study.luiz.planets.usecase.planet.SearchPlanetByIdUseCase;
import study.luiz.planets.usecase.planet.SearchPlanetByNameUseCase;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchPlanetController.class)
class SearchPlanetControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private SearchPlanetByNameUseCase searchPlanetByNameUseCase;

    @MockBean
    private SearchPlanetByIdUseCase searchPlanetByIdUseCase;

    @Test
    void shouldRespondOkSearchingById() throws Exception {
        when(searchPlanetByIdUseCase.execute(1L)).thenReturn(new Planet());

        mvc.perform(
                get("/planets").param("search", "1")
        ).andExpect(status().isOk());
    }

    @Test
    void shouldRespondOkSearchingByName() throws Exception {
        when(searchPlanetByNameUseCase.execute("Name")).thenReturn(new Planet());

        mvc.perform(
                get("/planets").param("search", "Name")
        ).andExpect(status().isOk());
    }

    @Test
    void shouldThrowExceptionSearchingNonExistentPlanet() throws Exception {
        when(searchPlanetByIdUseCase.execute(4L)).thenThrow(new PlanetNotFoundException());
        when(searchPlanetByNameUseCase.execute("4")).thenThrow(new PlanetNotFoundException());
        mvc.perform(
                get("/planets").param("search", "4")
        ).andExpect(status().isNotFound());
    }

}