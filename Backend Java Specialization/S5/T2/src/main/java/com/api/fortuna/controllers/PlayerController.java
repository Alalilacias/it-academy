package com.api.fortuna.controllers;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.exceptions.implementations.PlayerNotFoundException;
import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.dto.responses.ClientAuthResponse;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * Rest controller for players and all operations related to them.
 * TODO: Do Unit Testing.
 */
@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService service;

//    Create Methods
    /**
     * Registers a player in the system.
     *
     * @param request {@link ClientAuthRequest} instance.
     *                <br>Email and Password must be valid and present.
     *                <br>Username can be left empty.
     * @return Player DTO of the player created.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#register(ClientAuthRequest)
     */
    @PostMapping("/auth/register")
    public ClientAuthResponse registerPlayer(@RequestBody ClientAuthRequest request) throws EntityPersistenceException {
        return service.register(request);
    }
    /**
     * Creates a game of dice under the player's id, updates the player statistics.
     * @param id the id of the player.
     * @return {@link Game} that was created.
     * @throws PlayerNotFoundException If no player is found with the given id.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#throwDice(long)
     */
    @PostMapping("{id}/games")
    public Game throwDice(@PathVariable long id) throws PlayerNotFoundException, EntityPersistenceException {
        return service.throwDice(id);
    }


//    Read methods
    /**
     * Returns a List with DTO representation of all Players in the system.
     *
     * @return A List of Player DTOs, empty if there's none.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerService#getAll()
     */
    @GetMapping("/getAll")
    public List<PlayerDTO> getAllPlayers() throws EntityPersistenceException {
        return service.getAll();
    }

    /**
     * Returns a List with all the games associated with the player id in the system.
     *
     * @param id The id of the player whose games must be returned, must not be null.
     * @return A list of games associated with the given id, empty if there's none.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerService#getAllPlayerGames(long) 
     */
    @GetMapping("/{id}/games")
    public List<Game> getAllPlayerGames(@PathVariable long id) throws EntityPersistenceException {
        return service.getAllPlayerGames(id);
    }

    /**
     * Returns a list, ordered based on their win rate, of the players in the system.
     *
     * @return A list of player DTOs, ordered by their win rate. Empty if there's none.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerController#getAllPlayers()
     */
    @GetMapping("/players/ranking")
    public List<PlayerDTO> getRanking() throws EntityPersistenceException {
        return getAllPlayers().stream()
                .sorted(Comparator
                        .comparingDouble(PlayerDTO::winRate)
                        .thenComparing(PlayerDTO::username)
                        .reversed())
                .toList();
    }

    /**
     * Returns the player with the best win rate, the first on the ranking.
     *
     * @return Player entity with the highest win rate.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerController#getRanking()
     */
    @GetMapping("/players/ranking/winner")
    public PlayerDTO getBestRanking() throws EntityPersistenceException {
        return getRanking().getFirst();
    }

    /**
     * Returns the player with the worst win rate, the first on the ranking.
     *
     * @return Player entity with the lowest win rate.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerController#getRanking()
     */
    @GetMapping("/players/ranking/loser")
    public PlayerDTO getWorstRanking() throws EntityPersistenceException {
        return getRanking().getLast();
    }

//    Update methods
    /**
     * Updates an existing user's username.
     * @param id Must be null and >0
     * @param username must not be null
     * @return {@link PlayerDTO} of the updated user.
     * @throws PlayerNotFoundException If the player with the given id is not found.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#update(long, String)
     */
    @PutMapping("/update/{id}")
    public PlayerDTO updatePlayer(@PathVariable long id, @RequestParam String username) throws PlayerNotFoundException, EntityPersistenceException {
        return service.update(id, username);
    }


//    Delete methods
    /**
     * Deletes all games of the player that owns the given id.
     * @param id The id of the player whose games are to be deleted.
     * @return A text, detailing the success or lack thereof of the operation.
     * @throws PlayerNotFoundException If no player is found with the given id.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#deleteThrows(long)
     */
    @DeleteMapping({"{id}/games"})
    public String deletePlayerThrows(@PathVariable long id) throws PlayerNotFoundException, EntityPersistenceException {
        return service.deleteThrows(id);
    }
}
