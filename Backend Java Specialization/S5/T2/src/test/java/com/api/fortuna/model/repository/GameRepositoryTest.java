package com.api.fortuna.model.repository;

import com.api.fortuna.model.domain.Game;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataMongoTest
class GameRepositoryTest {

    @Mock
    private GameRepository repository;

    List<Game> games = List.of(
            new Game(0),
            new Game(1),
            new Game(5),
            new Game(1),
            new Game(0)
    );

    @Test
    void deleteAllByPlayerId() {
        repository.deleteAllByPlayerId(0);
        repository.deleteAllByPlayerId(1);

        verify(repository, times(1)).deleteAllByPlayerId(0);
        verify(repository, times(1)).deleteAllByPlayerId(1);
        verify(repository, times(0)).deleteAllByPlayerId(5);
    }

    @Test
    void findAllByPlayerId() {
        when(repository.findAllByPlayerId(1))
                .thenReturn(games.stream()
                        .filter(game -> game.getPlayerId() == 1)
                        .toList());
        assertEquals(2,repository.findAllByPlayerId(1).size());

        when(repository.findAllByPlayerId(0))
                .thenReturn(games.stream()
                        .filter(game -> game.getPlayerId() == 0)
                        .toList());
        assertEquals(2,repository.findAllByPlayerId(0).size());

        when(repository.findAllByPlayerId(5))
                .thenReturn(games.stream()
                        .filter(game -> game.getPlayerId() == 5)
                        .toList());
        assertEquals(1,repository.findAllByPlayerId(5).size());
    }
}