package com.api.fortuna.model.service;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.repository.GameRepository;
import com.api.fortuna.model.service.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Game entities and related operations regarding the repository.
 */
@Service
public class GameServiceImplementation implements GameService {
    @Autowired
    private GameRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Game createGame(Long id) throws EntityPersistenceException {
        try {
            return repository.save(new Game(id));
        } catch (Exception e){
            throw new EntityPersistenceException(e.getMessage(), e.getCause());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Game> getAll(long id) throws EntityPersistenceException {
        try {
            return repository.findAllByPlayerId(id);
        } catch (Exception e){
            throw new EntityPersistenceException(e.getMessage(), e.getCause());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAllGames(long id) throws EntityPersistenceException {
        try {
            repository.deleteAllByPlayerId(id);
        } catch (Exception e){
            throw new EntityPersistenceException(e.getMessage(), e);
        }
    }
}