package com.api.fortuna.model.dto.requests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientAuthRequestTest {
    private final String username = "";
    private final String email = "test@request.com";
    private final String password = "test_password";
    private final ClientAuthRequest request = new ClientAuthRequest(username, email, password);

    @Test
    void username() {
        assertEquals(username, request.username());
    }

    @Test
    void email() {
        assertEquals(email, request.email());
    }

    @Test
    void password() {
        assertEquals(password, request.password());
    }
}