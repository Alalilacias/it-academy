package com.api.fortuna.configuration;

import com.api.fortuna.configuration.filters.TokenFilter;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationProvider;

import static org.mockito.Mockito.mock;

@TestConfiguration
public class TestSecurityConfig {

    @Bean
    @Primary
    public TokenFilter tokenFilter() {
        return mock(TokenFilter.class);
    }

    @Bean
    @Primary
    public AuthenticationProvider authenticationProvider() {
        return mock(AuthenticationProvider.class);
    }
}