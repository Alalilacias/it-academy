package com.api.fortuna.model.dto.responses;

import com.api.fortuna.model.dto.PlayerDTO;

/**
 * This record represents the response to a client authorization request.
 *
 * @param player The DTO representation of the player class with all relevant information for the client.
 * @param token The String representation of the JWT token of the authorized user, if the user has been properly registered/authenticated.
 */
public record ClientAuthResponse(PlayerDTO player, String token) {}
