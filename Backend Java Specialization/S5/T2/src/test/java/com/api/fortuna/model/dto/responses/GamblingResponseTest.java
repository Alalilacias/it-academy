package com.api.fortuna.model.dto.responses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamblingResponseTest {
    private final long millisecondsTaken = 12000;
    private final long gamesPlayed = 3587;
    private final double timesPerGame = 0.935;
    private final GamblingResponse response = new GamblingResponse(millisecondsTaken, gamesPlayed, timesPerGame);

    @Test
    void millisecondsTaken() {
        assertEquals(millisecondsTaken, response.millisecondsTaken());
    }

    @Test
    void gamesPlayed() {
        assertEquals(gamesPlayed, response.gamesPlayed());
    }

    @Test
    void timePerGame() {
        assertEquals(timesPerGame, response.timePerGame());
    }
}