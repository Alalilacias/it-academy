package com.api.fortuna.model.service;

import com.api.fortuna.exceptions.EntityPersistenceException;
import com.api.fortuna.exceptions.PlayerNotFoundException;
import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.domain.Player;
import com.api.fortuna.model.domain.enums.Roles;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.repository.PlayerRepository;
import com.api.fortuna.model.service.interfaces.GameService;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing Player entities and related operations.
 * TODO Do unit testing.
 */
@Service
public class PlayerServiceImplementation implements PlayerService {
    @Autowired
    private PlayerRepository repository;
    @Autowired
    private GameService service;
    @Autowired
    private static PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerDTO create (ClientAuthRequest request) throws EntityPersistenceException {
        try {
            return repository.save(toRegisterPlayer(request)).toDTO();
        } catch (Exception e){
            throw new EntityPersistenceException(e.getMessage(), e.getCause());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getOne(long id) throws PlayerNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Unable to find player at method update() in PlayerServiceImplementation."));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PlayerDTO> getAll() throws EntityPersistenceException {
        try {
            return repository.findAll().stream()
                    .map(Player::toDTO)
                    .toList();
        } catch (DataAccessException e) {
            throw new EntityPersistenceException("Failed to retrieve players from the database", e);
        } catch (Exception e) {
            throw new EntityPersistenceException("An unexpected error occurred while retrieving players", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Game> getAllPlayerGames(long id) throws EntityPersistenceException {
        return service.getAll(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerDTO update (long id, String username) throws PlayerNotFoundException, EntityPersistenceException {
        Player player = getOne(id);

        player.setUsername(username);

        try{
            return repository.save(player).toDTO();
        } catch (Exception e){
            throw new EntityPersistenceException(e.getMessage(), e.getCause());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Game throwDice(long id) throws PlayerNotFoundException, EntityPersistenceException {
        Player player = getOne(id);
        Game game = service.createGame(id);

        player.addResult(game.isWon());

        return game;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteThrows(long id) throws PlayerNotFoundException, EntityPersistenceException {
        Optional<Player> player = repository.findById(id);
        if(player.isEmpty()){
            throw new PlayerNotFoundException("Unable to find player at method throwDice() in PlayerServiceImplementation.");
        }

        return service.deleteAllGames(id)
                ? "All games for player ID: " + id + " deleted."
                : "Unable to delete all games for player ID: " + id;
    }

    /**
     * Converts ClientAuthRequest into a Player object for registration purposes.
     * If the username is blank or empty, it assigns a default anonymous username.
     *
     * @return {@link Player} with the given or default username, email, and password
     */
    public Player toRegisterPlayer(ClientAuthRequest request){
        if(request.username().isBlank() || request.username().isEmpty()){
            return Player.builder()
                    .username("ANONYMOUS")
                    .email(request.email())
                    .password(passwordEncoder.encode(request.password()))
                    .role(Roles.GUEST)
                    .build();
        }
        return Player.builder()
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Roles.USER)
                .build();
    }
}