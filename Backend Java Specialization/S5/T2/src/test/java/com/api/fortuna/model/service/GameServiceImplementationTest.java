package com.api.fortuna.model.service;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.repository.GameRepository;
import com.api.fortuna.model.service.interfaces.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class GameServiceImplementationTest {

    @Mock
    private GameRepository repository;

    @InjectMocks
    private GameServiceImplementation service;

    private final Game game = new Game(0);
    private final List<Game> games= List.of(
            new Game(1),
            new Game(2),
            new Game(1),
            new Game(2),
            new Game(1)
    );

    @BeforeEach
    void setUp() {
    }

    @Test
    void createGame() throws EntityPersistenceException {
        when(repository.save(any(Game.class))).thenReturn(game);

        Game createdGame = service.createGame(0L);

        assertNotNull(createdGame);
        assertEquals(0L, createdGame.getPlayerId());
        verify(repository, times(1)).save(any(Game.class));
    }

    @Test
    void getAll() throws EntityPersistenceException {
        when(repository.findAllByPlayerId(1L)).thenReturn(games.stream()
                .filter(game -> game.getPlayerId() == 1)
                .toList());

        List<Game> returnedGames = service.getAll(1L);

        assertNotNull(returnedGames);
        assertEquals(3, returnedGames.size());
        assertEquals(1L, returnedGames.getFirst().getPlayerId());
        verify(repository, times(1)).findAllByPlayerId(1L);

        when(repository.findAllByPlayerId(2L)).thenReturn(games.stream()
                .filter(game -> game.getPlayerId() == 2)
                .toList());

        List<Game> returnedGamesII = service.getAll(2L);

        assertNotNull(returnedGamesII);
        assertEquals(2, returnedGamesII.size());
        assertEquals(2L, returnedGamesII.getFirst().getPlayerId());
        verify(repository, times(1)).findAllByPlayerId(2L);
    }

    @Test
    void deleteAllGames() throws EntityPersistenceException {
        doNothing().when(repository).deleteAllByPlayerId(1L);

        service.deleteAllGames(1L);

        verify(repository, times(1)).deleteAllByPlayerId(1L);
    }
}