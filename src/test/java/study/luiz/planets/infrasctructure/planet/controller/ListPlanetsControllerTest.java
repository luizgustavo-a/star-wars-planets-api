package study.luiz.planets.infrasctructure.planet.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import study.luiz.planets.entity.planet.model.Planet;
import study.luiz.planets.usecase.planet.ListPlanetsUseCase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ListPlanetsController.class)
class ListPlanetsControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ListPlanetsUseCase listPlanetsUseCase;

    @Test
    void shouldListAllPlanets() throws Exception {
        List<Planet> planets = new ArrayList<>();
        planets.add(new Planet());

        when(listPlanetsUseCase.execute()).thenReturn(planets);

        mvc.perform(
                get("/planets")
        ).andExpect(status().isOk());
    }
}