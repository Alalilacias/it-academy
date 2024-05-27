package com.api.fortuna.controllers;

import com.api.fortuna.exceptions.implementations.EntityPersistenceException;
import com.api.fortuna.exceptions.implementations.PlayerNotFoundException;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.dto.responses.ClientAuthResponse;
import com.api.fortuna.model.service.interfaces.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class SecurityController {
    @Autowired
    private PlayerService service;

    /**
     * Registers a player in the system.
     *
     * @param request {@link ClientAuthRequest} instance.
     *                <br>Email and Password must be valid and present.
     *                <br>Username can be left empty.
     * @return The ClientAuthResponse, with the DTO representation of the player entity and the JWT token that authenticates it.
     * @throws EntityPersistenceException If the entity is null, is presumed to be present in database but isn't, or
     * if it uses optimistic locking and has a version attribute with a different value from that found in the persistence store
     * @see PlayerService#register(ClientAuthRequest)
     */
    @Operation(summary = "Registers a player in the system.",
            description = "Saves user in the system, creates a JWT and returns it to the client along with the representation of the user.")
    @PostMapping("/register")
    public ClientAuthResponse registerPlayer(@RequestBody ClientAuthRequest request) throws EntityPersistenceException {
        return service.register(request);
    }

    @PostMapping("/login")
    public ClientAuthResponse authenticatePlayer(@RequestBody ClientAuthRequest request) throws PlayerNotFoundException {
        return service.authenticate(request);
    }
}