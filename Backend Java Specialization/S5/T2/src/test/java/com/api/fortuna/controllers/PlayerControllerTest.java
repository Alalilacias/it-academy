package com.api.fortuna.controllers;

import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.domain.Player;
import com.api.fortuna.model.domain.enums.Roles;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.responses.GamblingResponse;
import com.api.fortuna.model.service.FortunaTokenService;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest()
@AutoConfigureMockMvc
@WithMockUser(roles = "USER")
class PlayerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService service;

    @MockBean
    private FortunaTokenService tokenService;

    @InjectMocks
    private PlayerController controller;

    private String token;

    @BeforeEach
    public void setUp() {
        token = "mock_token";

        when(tokenService.generateToken(any(Player.class))).thenReturn(token);
        when(tokenService.validateToken(anyString(), any(Player.class))).thenReturn(true);
    }

    @Test
    void throwDice() throws Exception {
        when(service.throwDice(token)).thenReturn(Mockito.mock(Game.class));

        mockMvc.perform(post("/players/games")
                        .header("authorization", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void throwDiceWithAddiction() throws Exception {
        when(service.simulateGamblingAddiction(eq(token), anyDouble())).thenReturn(Mockito.mock(GamblingResponse.class));

        mockMvc.perform(post("/players/games/addiction/0.1")
                        .header("authorization", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getAllPlayerGames() throws Exception {
        when(service.getAllPlayerGames(token)).thenReturn(Collections.singletonList(Mockito.mock(Game.class)));

        mockMvc.perform(get("/players/games")
                        .header("authorization", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getRanking() throws Exception {
        when(service.getAll()).thenReturn(Collections.singletonList(Mockito.mock(PlayerDTO.class)));

        mockMvc.perform(get("/players/ranking")
                        .header("authorization", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getBestRanking() throws Exception {
        when(service.getAll()).thenReturn(List.of(
                new PlayerDTO(1L, "Player1", Roles.USER, 0.8F),
                new PlayerDTO(2L, "Player2", Roles.USER, 0.7F),
                new PlayerDTO(3L, "Player3", Roles.USER, 0.9F)
        ));

        mockMvc.perform(get("/players/ranking/winner")
                        .header("authorization", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getWorstRanking() throws Exception {
        when(service.getAll()).thenReturn(List.of(
                new PlayerDTO(1L, "Player1", Roles.USER, 0.8F),
                new PlayerDTO(2L, "Player2", Roles.USER, 0.7F),
                new PlayerDTO(3L, "Player3", Roles.USER, 0.9F)
        ));

        mockMvc.perform(get("/players/ranking/loser")
                        .header("authorization", token)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updatePlayer() throws Exception {
        when(service.update(eq(token), anyString())).thenReturn(Mockito.mock(PlayerDTO.class));

        mockMvc.perform(put("/players")
                        .header("authorization", token)
                        .content("Update Username")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deletePlayerThrows() throws Exception {
        when(service.deleteThrows(token)).thenReturn("All games deleted");

        mockMvc.perform(delete("/players/games")
                        .header("authorization", token))
                .andExpect(status().isOk());
    }
}