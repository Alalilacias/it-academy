package com.api.fortuna.model.service.interfaces;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.model.domain.Game;

import java.util.List;

public interface GameService {
    /**
     * Creates a game with the given player ID.
     *
     * @param id The id of the player that will play.
     * @return {@link Game} entity.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     */
    Game createGame(Long id) throws EntityPersistenceException;

    /**
     * Returns all game entities associated with the given id.
     *
     * @param id The id of the player whose games must be returned.
     * @return List of game entities.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     */
    List<Game> getAll(long id) throws EntityPersistenceException;

    /**
     * Deletes all games associated with the given player ID.
     *
     * @param id the id of the player whose games will be deleted.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     *                                    if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     */
    void deleteAllGames(long id) throws EntityPersistenceException;
}
