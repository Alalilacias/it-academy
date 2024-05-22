package com.api.fortuna.controllers;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.exceptions.implementations.PlayerNotFoundException;
import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.responses.GamblingResponse;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

/**
 * Rest controller for players and all operations related to them.
 * TODO: Restructure, Add RequestHeaders and Do Unit Testing.
 */
@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService service;

//    Create Methods
    /**
     * Creates a game of dice under the player's id, updates the player statistics.
     * @param token the JWT token of the user.
     * @return {@link Game} that was created.
     * @throws PlayerNotFoundException If no player is found with the given id.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#throwDice(String) 
     */
    @PostMapping("/games")
    public Game throwDice(@RequestHeader("authorization") String token) throws PlayerNotFoundException, EntityPersistenceException {
        return service.throwDice(token);
    }

    /**
     * Simulates max speed gambling for a user for the amount of minutes given by a path variable.
     * 
     * @param token the JWT token of the user.
     * @param minutes the time, in minutes, the user wants to experience the wonders of max speed betting.
     * @return List of the full amount of games the user speed played.
     * @throws PlayerNotFoundException If no player is found with the given id.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store.
     * @see PlayerService#simulateGamblingAddiction(String, double)
     */
    @PostMapping("/games/addiction/{minutes}")
    public GamblingResponse throwDiceWithAddiction(@RequestHeader("authorization") String token, @PathVariable double minutes) throws PlayerNotFoundException, EntityPersistenceException {
        return service.simulateGamblingAddiction(token, minutes);
    }


    /**
     * Returns a List with all the games associated with the player token in the system.
     *
     * @param token The token of the player whose games must be returned, must not be null.
     * @return A list of games associated with the given token, empty if there's none.
     * @throws PlayerNotFoundException if no player is found associated with the given token.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerService#getAllPlayerGames(String)
     */
    @GetMapping("/games")
    public List<Game> getAllPlayerGames(@RequestHeader("authorization") String token) throws EntityPersistenceException, PlayerNotFoundException {
        return service.getAllPlayerGames(token);
    }

    /**
     * Returns a list, ordered based on their win rate, of the players in the system.
     *
     * @return A list of player DTOs, ordered by their win rate. Empty if there's none.
     * @throws EntityPersistenceException If there's any issue with extracting the players from the database.
     * @see PlayerService#getAll()
     */
    @GetMapping("/ranking")
    public List<PlayerDTO> getRanking() throws EntityPersistenceException {
        return service.getAll().stream()
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
    @GetMapping("/ranking/winner")
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
    @GetMapping("/ranking/loser")
    public PlayerDTO getWorstRanking() throws EntityPersistenceException {
        return getRanking().getLast();
    }

//    Update methods
    /**
     * Updates an existing user's username.
     * @param token Must be null and >0
     * @param username must not be null
     * @return {@link PlayerDTO} of the updated user.
     * @throws PlayerNotFoundException If the player with the given token is not found.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#update(String, String)
     */
    @PutMapping
    public PlayerDTO updatePlayer(@RequestHeader("authorization") String token, @RequestBody String username) throws PlayerNotFoundException, EntityPersistenceException {
        return service.update(token, username);
    }


//    Delete methods
    /**
     * Deletes all games of the player that owns the given token.
     * @param token The token of the player whose games are to be deleted.
     * @return A text, detailing the success or lack thereof of the operation.
     * @throws PlayerNotFoundException If no player is found with the given token.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#deleteThrows(String)
     */
    @DeleteMapping({"/games"})
    public String deletePlayerThrows(@RequestHeader("authorization") String token) throws PlayerNotFoundException, EntityPersistenceException {
        return service.deleteThrows(token);
    }
}
