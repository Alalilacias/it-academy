package com.api.fortuna.model.dto.responses;

import com.api.fortuna.model.dto.PlayerDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientAuthResponseTest {
    private final PlayerDTO playerDTO = Mockito.mock(PlayerDTO.class);
    private final String token = "";
    private final ClientAuthResponse response = new ClientAuthResponse(playerDTO, token);

    @Test
    void player() {
        assertEquals(playerDTO, response.player());
    }

    @Test
    void token() {
        assertEquals(token, response.token());
    }
}