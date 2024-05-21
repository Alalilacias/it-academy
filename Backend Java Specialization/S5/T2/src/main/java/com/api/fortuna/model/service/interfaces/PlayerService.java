package com.api.fortuna.model.service.interfaces;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.model.domain.Player;
import com.api.fortuna.exceptions.implementations.PlayerNotFoundException;
import com.api.fortuna.model.dto.responses.ClientAuthResponse;
import com.api.fortuna.model.repository.PlayerRepository;
import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;

import java.util.List;

/**
 * Interface for managing player entities and their operations.
 * @see Player
 */
public interface PlayerService {

    /**
     * Saves a player to the database, serves as the registration method for security.
     *
     * @param request The ClientAuthRequest, with all necessary fields filled.
     * @return The ClientAuthResponse, with the DTO representation of the player entity and the JWT token that authenticates it.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerRepository#save(Object)
     * @see ClientAuthRequest
     * @see ClientAuthResponse
     * @see PlayerDTO
     */
    ClientAuthResponse register(ClientAuthRequest request) throws EntityPersistenceException;
    /**
     * Creates a game using the player's id and modifies the player's counts depending on the result.
     * @param id The id of the player.
     * @return {@link Game} entity.
     * @throws PlayerNotFoundException If no player is found with the id.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see GameService#createGame(Long)
     * @see Player#addResult(boolean)
     */
    Game throwDice (long id) throws PlayerNotFoundException, EntityPersistenceException;

    /**
     * Returns player entity with the given id.
     *
     * @param id The id of the player to find.
     * @return Player Entity, never null.
     * @throws PlayerNotFoundException If the player cannot be found.
     * @see PlayerRepository#findById(Object)
     */
    Player getOne (long id) throws PlayerNotFoundException;

    /**
     * Authenticates the user in question and returns the appropriate response to the client.
     *
     * @param request {@link ClientAuthRequest} instance, only email and password are necessary.
     * @return {@link ClientAuthResponse} instance, with the DTO representation of the player authenticated and the JWT corresponding.
     * @throws PlayerNotFoundException if no player can be found with the given data.
     */
    ClientAuthResponse authenticate(ClientAuthRequest request) throws PlayerNotFoundException;
    /**
     * Returns all player entities in the repository.
     *
     * @return A list of all Player DTOs in the system, empty if there's none.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerRepository#findAll()
     */
    List<PlayerDTO> getAll() throws EntityPersistenceException;
    /**
     * Returns all game entities associated with the given player id.
     * @param id The id of the player associated with the given id.
     * @return A list of game entities, empty if there's none.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see GameService#getAll(long) 
     */
    List<Game> getAllPlayerGames(long id) throws EntityPersistenceException;

    /**
     * Updates the username of the owner of the id.
     * @param id The id of the player whose username will be modified.
     * @param username The new username to be applied to the player.
     * @return The saved entity, will never be null.
     * @throws PlayerNotFoundException If no player is found with the id.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     */
    PlayerDTO update(long id, String username) throws PlayerNotFoundException, EntityPersistenceException;

    /**
     * Deletes all games of the player that owns the given id.
     *
     * @param id The id of the player whose games are to be deleted.
     * @return A text, detailing the success or lack thereof of the operation.
     * @throws PlayerNotFoundException If no player is found with the given id.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see GameService#deleteAllGames(long)  
     */
    String deleteThrows(long id) throws PlayerNotFoundException, EntityPersistenceException;
}
