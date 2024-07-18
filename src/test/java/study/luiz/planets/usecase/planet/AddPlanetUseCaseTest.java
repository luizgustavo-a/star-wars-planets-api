package study.luiz.planets.usecase.planet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AddPlanetUseCaseTest {

    @Autowired
    private AddPlanetUseCase addPlanetUseCase;

    @Test
    void shouldReturn5AsTheNumberOfApparitionsOfTatooine() {
        var numberApparitions = addPlanetUseCase.numberApparitions("Tatooine");

        Assertions.assertEquals(5, numberApparitions);
    }

}