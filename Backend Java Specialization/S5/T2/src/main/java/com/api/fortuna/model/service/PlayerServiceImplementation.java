package com.api.fortuna.model.service;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.exceptions.implementations.PlayerNotFoundException;
import com.api.fortuna.model.domain.Game;
import com.api.fortuna.model.domain.Player;
import com.api.fortuna.model.domain.enums.Roles;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.dto.responses.ClientAuthResponse;
import com.api.fortuna.model.dto.responses.GamblingResponse;
import com.api.fortuna.model.repository.PlayerRepository;
import com.api.fortuna.model.service.interfaces.GameService;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Player entities and related operations.
 * TODO Do unit testing.
 */
@Service
public class PlayerServiceImplementation implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private GameService gameService;
    @Autowired
    private FortunaTokenService tokenService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientAuthResponse register(ClientAuthRequest request) throws EntityPersistenceException {
        try {
            Player player = playerRepository.save(toRegisterPlayer(request));
            return new ClientAuthResponse(
                    player.toDTO(),
                    tokenService.generateToken(player)
            );
        } catch (Exception e){
            throw new EntityPersistenceException(e.getMessage(), e.getCause());
        }
    }

//    public void registerAdmin() throws EntityPersistenceException {
//        try {
//            Player admin = Player.builder()
//                    .username("IT_ACADEMY_ADMIN")
//                    .email("it@academy.cat")
//                    .password(passwordEncoder.encode("IT_academy_2024"))
//                    .role(Roles.ADMIN)
//                    .build();
//            playerRepository.save(admin);
//            System.out.println(new ClientAuthResponse(
//                    admin.toDTO(),
//                    tokenService.generateToken(admin)
//            ));
//        } catch (Exception e){
//            throw new EntityPersistenceException(e.getMessage(), e.getCause());
//        }
//    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getOne(long id) throws PlayerNotFoundException {
        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Unable to find player at method update() in PlayerServiceImplementation."));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Player getOne(String email) throws PlayerNotFoundException {
        return playerRepository.findPlayerByEmail(email)
                .orElseThrow(() -> new PlayerNotFoundException("Unable to find player at method update() in PlayerServiceImplementation."));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ClientAuthResponse authenticate(ClientAuthRequest request) throws  PlayerNotFoundException {
        Player player = playerRepository.findPlayerByEmail(request.email())
                .orElseThrow(() -> new PlayerNotFoundException("Unable to find player at method authenticate() in PlayerServiceImplementation."));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        return new ClientAuthResponse(
                player.toDTO(),
                tokenService.generateToken(player)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PlayerDTO> getAll() throws EntityPersistenceException {
        try {
            return playerRepository.findAll().stream()
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
    public List<Game> getAllPlayerGames(String token) throws EntityPersistenceException, PlayerNotFoundException {
        Player player = getOne(tokenService.getUsername(token.substring(7)));
        return gameService.getAll(player.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerDTO update (String token, String username) throws PlayerNotFoundException, EntityPersistenceException {
        Player player = getOne(tokenService.getUsername(token.substring(7)));

        player.setUsername(username);

        try{
            return playerRepository.save(player).toDTO();
        } catch (Exception e){
            throw new EntityPersistenceException(e.getMessage(), e.getCause());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Game throwDice(String token) throws PlayerNotFoundException, EntityPersistenceException {
        Player player = getOne(tokenService.getUsername(token.substring(7)));
        Game game = gameService.createGame(player.getId());

        player.addResult(game.isWon());
        playerRepository.save(player);
        return game;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GamblingResponse simulateGamblingAddiction(String token, double minutes) throws PlayerNotFoundException, EntityPersistenceException {
        Player player = getOne(tokenService.getUsername(token.substring(7)));
        Game game;

        long startTime = System.currentTimeMillis();
        long totalRepetitions = 0;

        do {
            game = gameService.createGame(player.getId());
            player.addResult(game.isWon());
            totalRepetitions++;
        } while(System.currentTimeMillis() - startTime < ((long) (minutes * 60 * 1000)));

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        playerRepository.save(player);

        return new GamblingResponse(
                totalTime,
                totalRepetitions,
                (double) totalRepetitions /totalTime
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deleteThrows(String token) throws PlayerNotFoundException, EntityPersistenceException {
        Player player = getOne(tokenService.getUsername(token.substring(7)));
        gameService.deleteAllGames(player.getId());

        player.cleanResults();
        playerRepository.save(player);

        return "All games for player ID: " + player.getId() + " deleted.";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String deletePlayer(long id) {
        playerRepository.deleteById(id);
        return "Player ID: " + id + " deleted.";
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