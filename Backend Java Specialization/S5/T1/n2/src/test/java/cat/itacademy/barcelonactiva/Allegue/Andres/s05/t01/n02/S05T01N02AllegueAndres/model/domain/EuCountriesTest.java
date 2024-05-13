package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n02.S05T01N02AllegueAndres.model.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuCountriesTest {

    @Test
    void getFlowerType() {
        assertEquals("EU", EuCountries.getFlowerType("Spain"));
        assertEquals("NON_EU", EuCountries.getFlowerType("Morocco"));
    }
}