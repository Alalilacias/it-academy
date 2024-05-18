package com.api.fortuna.model.service.interfaces;

import com.api.fortuna.exceptions.PlayerNotFoundException;
import com.api.fortuna.model.dto.PlayerDTO;
import com.api.fortuna.model.dto.requests.ClientAuthRequest;

public interface PlayerService {

    /**
     * Saves a player to the database.
     * @param request see ClientAuthRequest documentation for more information.
     * @return the saved entity, will never be null.
     */
    PlayerDTO create(ClientAuthRequest request);

    /**
     * Updates the username of the owner of the id.
     * @param id The id of the player whose username will be modified.
     * @param username The new username to be applied to the player.
     * @return The saved entity, will never be null.
     * @throws PlayerNotFoundException If no player is found with the id.
     */
    PlayerDTO update(long id, String username) throws PlayerNotFoundException;
}
