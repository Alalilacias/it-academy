package com.api.fortuna.model.dto;

import com.api.fortuna.model.domain.enums.Roles;

/**
 * TODO finish and test.
 *
 * @param id
 * @param username
 * @param roles
 * @param winRate
 */
public record PlayerDTO(long id, String username, Roles roles, float winRate) {
}
