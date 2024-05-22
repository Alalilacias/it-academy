package com.api.fortuna.exceptions.implementations;

/**
 * Exception thrown if any exception is thrown by persistence related operations.
 */
public class EntityPersistenceException extends Exception {
    public EntityPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
