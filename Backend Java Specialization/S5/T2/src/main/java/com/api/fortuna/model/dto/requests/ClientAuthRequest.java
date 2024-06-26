package com.api.fortuna.model.dto.requests;

/**
 * This record represents a client authorization requests.
 *
 * @param username the username of the client; can be left blank for anonymous registration or login.
 * @param email of the client; must be provided.
 * @param password of the client; must be provided.
 */
public record ClientAuthRequest (String username, String email, String password) {}