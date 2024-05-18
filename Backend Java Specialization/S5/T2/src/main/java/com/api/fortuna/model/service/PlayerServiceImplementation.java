package com.api.fortuna.model.service;

import com.api.fortuna.exceptions.PlayerNotFoundException;
import com.api.fortuna.model.domain.Player;
import com.api.fortuna.model.domain.enums.Roles;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.repository.PlayerRepository;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service implementation for managing Player entities and related operations regarding the repository.
 */
@Service
public class PlayerServiceImplementation implements PlayerService {
    @Autowired
    private PlayerRepository repository;
    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static final String ANONYMOUS = "ANONYMOUS";

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerDTO create(ClientAuthRequest request) {
        return repository.save(toRegisterPlayer(request)).toDTO();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PlayerDTO update(long id, String username) throws PlayerNotFoundException {
        Player player = repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Unable to find player at method update() in PlayerServiceImplementation."));

        player.setUsername(username);
        return repository.save(player).toDTO();
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