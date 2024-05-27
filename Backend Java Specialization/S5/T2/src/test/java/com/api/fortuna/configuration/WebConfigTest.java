package com.api.fortuna.configuration;

import com.api.fortuna.model.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@Import(WebConfig.class)
class WebConfigTest {

    @MockBean
    private PlayerRepository repository;

    @Autowired
    private UserDetailsService detailsService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AuthenticationProvider authProvider;

    @Autowired
    private AuthenticationManager authManager;

    @Test
    void userDetailsService() {
        assertNotNull(detailsService);
    }

    @Test
    void passwordEncoder() {
        assertNotNull(encoder);
    }

    @Test
    void authenticationProvider() {
        assertNotNull(authProvider);
        assertInstanceOf(DaoAuthenticationProvider.class, authProvider);
    }

    @Test
    void authenticationManager() {
        assertNotNull(authManager);
    }
}