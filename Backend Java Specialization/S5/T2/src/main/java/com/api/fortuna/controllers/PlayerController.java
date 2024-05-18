package com.api.fortuna.controllers;

import com.api.fortuna.exceptions.PlayerNotFoundException;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;
import com.api.fortuna.model.service.interfaces.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO finish and test.
 */
@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService service;

    /**
     * Method that registers a player in the system.
     *
     * @param request {@link ClientAuthRequest} instance.
     *                <br>Email and Password must be valid and present.
     *                <br>Username can be left empty.
     * @return Player DTO of the player created.
     */
    @PostMapping("/auth/register")
    public PlayerDTO registerPlayer(@RequestBody ClientAuthRequest request){
        return service.create(request);
    }

    /**
     * Method that updates an existing user's username.
     * @param id Must be null and >0
     * @param username must not be null
     * @return {@link PlayerDTO} of the updated user.
     * @throws PlayerNotFoundException If the player with the given id is not found.
     * @see PlayerService#update(long, String)
     */
    @PutMapping("/update/{id}")
    public PlayerDTO updatePlayer(@PathVariable int id, @RequestParam String username) throws PlayerNotFoundException {
        return service.update(id, username);
    }

    @PostMapping("/play/{id}")
    public void throwDice(){

    }

}
