package com.api.fortuna.model.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private final Game game = new Game(1);

    @Test
    void getId() {
        assertNull(game.getId());
    }

    @Test
    void getPlayerID() {
        assertEquals(1L, game.getPlayerID());
    }

    @Test
    void getMuliebris() {
        int muliebris = game.getMuliebris();
        assertTrue(muliebris > 0 && muliebris < 7);
    }

    @Test
    void getPrimigenia() {
        int primigenia = game.getPrimigenia();
        assertTrue(primigenia > 0 && primigenia < 7);
    }
}