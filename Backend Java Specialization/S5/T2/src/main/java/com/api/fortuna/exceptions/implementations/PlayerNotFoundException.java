package com.api.fortuna.exceptions.implementations;

/**
 * Exception thrown if the service cannot find the player with the given id.
 */
public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(String message) {
        super(message);
    }
}
