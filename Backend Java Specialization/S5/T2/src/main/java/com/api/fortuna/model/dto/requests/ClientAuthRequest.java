package com.api.fortuna.model.dto.requests;

/**
 * This record represents a client authorization requests.
 * It is made with personalized methods, so it can be used for both registration and authorization requests.
 * @param username the username of the client; can be left blank for anonymous registration or login.
 * @param email of the client; must be provided.
 * @param password of the client; must be provided.
 */
public record ClientAuthRequest (String username, String email, String password) {}