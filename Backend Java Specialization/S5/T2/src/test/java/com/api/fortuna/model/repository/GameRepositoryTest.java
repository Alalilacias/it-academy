package com.api.fortuna.model.repository;

import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.service.interfaces.GameService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class GameRepositoryTest {

    @Mock
    private GameRepository repository;

    @InjectMocks
    private GameService service;

    List<Game> games = List.of(
            new Game(0),
            new Game(1),
            new Game(5),
            new Game(1),
            new Game(0)
    );

    @Test
    void deleteAllByPlayerId() {
        repository.saveAll(games);

        assertEquals(5, repository.findAll().size());

        repository.deleteAllByPlayerId(0);

        assertEquals(3, repository.findAll().size());

        repository.deleteAllByPlayerId(1);

        assertEquals(1, repository.findAll().size());
    }

    @Test
    void findAllByPlayerId() {
        assertEquals(1,repository.findAllByPlayerId(5).size());
    }
}