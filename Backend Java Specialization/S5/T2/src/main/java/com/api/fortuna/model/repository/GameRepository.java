package com.api.fortuna.model.repository;

import com.api.fortuna.model.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MongoRepository< T, ID > extension for the game class.
 */
@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    /**
     * Deletes all game entities associated with the given player id.
     *
     * @param playerId The id of the player whose games must be eliminated.
     * @return A boolean representing the success or lack thereof of the operation.
     */
    boolean deleteAllByPlayerId(long playerId);

    /**
     * Returns all game entities associated with the given player id.
     *
     * @param playerId The id of the player whose games must be returned.
     * @return A list of game entities.
     */
    List<Game> findAllByPlayerId(long playerId);
}
