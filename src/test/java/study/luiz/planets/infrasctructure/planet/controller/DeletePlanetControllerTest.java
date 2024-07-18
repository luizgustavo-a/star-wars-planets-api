package study.luiz.planets.infrasctructure.planet.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import study.luiz.planets.entity.planet.exception.PlanetNotFoundException;
import study.luiz.planets.entity.planet.model.Planet;
import study.luiz.planets.usecase.planet.DeletePlanetUseCase;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeletePlanetController.class)
public class DeletePlanetControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DeletePlanetUseCase deletePlanetUseCase;

    @Test
    void deleteShouldBeSuccessful() throws Exception {
        when(deletePlanetUseCase.execute(1L)).thenReturn(new Planet());

        mvc.perform(
                delete("/planets/{id}", 1L)
                ).andExpect(status().isOk());
    }

    @Test
    void deleteShouldBeUnsuccessful() throws Exception {
        when(deletePlanetUseCase.execute(1L)).thenThrow(new PlanetNotFoundException());

        mvc.perform(
                        delete("/planets/{id}", 1L)
                )
                .andExpect(status().isNotFound());
    }



}