package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.dto.requests;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain.Flower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerCreateRequestTest {
    private static final Flower flower = Flower.builder()
            .name("Margarita")
            .country("Spain")
            .build();

    private static final FlowerCreateRequest request = new FlowerCreateRequest("Margarita", "Spain");

    @Test
    void toFlower() {
        assertEquals(flower.getName(), request.toFlower().getName());
        assertEquals(flower.getCountry(), request.toFlower().getCountry());
    }
}