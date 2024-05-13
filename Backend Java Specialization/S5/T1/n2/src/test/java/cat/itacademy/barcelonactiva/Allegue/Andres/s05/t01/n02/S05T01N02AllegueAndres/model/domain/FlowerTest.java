package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.FlowerDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private static final Flower flower = Flower.builder()
            .name("Margarita")
            .country("Spain")
            .build();

    private static final FlowerDTO flowerDTO = FlowerDTO.builder()
            .name("Margarita")
            .country("Spain")
            .type(EuCountries.getFlowerType("Spain"))
            .build();

    @Test
    void toDTO() {
        assertEquals(flowerDTO, flower.toDTO());
    }
}