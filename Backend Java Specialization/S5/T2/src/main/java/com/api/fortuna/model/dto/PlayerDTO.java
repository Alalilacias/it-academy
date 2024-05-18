package com.api.fortuna.model.dto;

import com.api.fortuna.model.domain.enums.Roles;

/**
 * DTO Representation of the Player class.
 * @param id of the user.
 * @param username of the user.
 * @param roles of the user. In this implementation of the app, it's always going to be a single role.
 * @param winRate of the user. Always available, without having to use a specific method.
 */
public record PlayerDTO (Long id, String username, Roles roles, float winRate) {
}
