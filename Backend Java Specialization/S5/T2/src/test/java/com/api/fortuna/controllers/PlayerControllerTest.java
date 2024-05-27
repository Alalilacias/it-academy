package com.api.fortuna.controllers;

import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService service;

    private final String token = "valid_token";

    @Test
    void throwDice() throws Exception {
        Game game = Mockito.mock(Game.class);
        when(service.throwDice(token)).thenReturn(game);

        mockMvc.perform(post("/players/game")
                        .header("authorization", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void throwDiceWithAddiction() {
    }

    @Test
    void getAllPlayerGames() {
    }

    @Test
    void getRanking() {
    }

    @Test
    void getBestRanking() {
    }

    @Test
    void getWorstRanking() {
    }

    @Test
    void updatePlayer() {
    }

    @Test
    void deletePlayerThrows() {
    }
}