package com.api.fortuna.controllers;

import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.dto.responses.ClientAuthResponse;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SecurityControllerTest {
    @Mock
    private PlayerService service;

    @Autowired
    private MockMvc mockMvc;

    private ClientAuthRequest request;
    private ClientAuthResponse response;

    @Mock
    private PlayerDTO playerDTO;

    @BeforeEach
    void setUp() {
        request = new ClientAuthRequest("test user",
                "test@email.com",
                "testPassword");
        response = new ClientAuthResponse(
                playerDTO,
                "token"
        );
    }

    @Test
    void registerPlayer() throws Exception {
        when(service.register(request)).thenReturn(response);

        ClientAuthResponse testAuthResponse = service.register(request);

        assertNotNull(testAuthResponse);
        assertNotNull(testAuthResponse.player());
        assertNotNull(testAuthResponse.token());

        mockMvc.perform(post("/auth/register"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void authenticatePlayer() throws Exception {
        when(service.authenticate(request)).thenReturn(response);

        ClientAuthResponse testAuthResponse = service.authenticate(request);

        assertNotNull(testAuthResponse);
        assertNotNull(testAuthResponse.player());
        assertNotNull(testAuthResponse.token());

        mockMvc.perform(post("/auth/login"))
                .andExpect(status().isBadRequest());
    }
}