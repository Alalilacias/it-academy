package com.api.fortuna.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static com.api.fortuna.configuration.Constants.Security.*;

/**
 * TODO finish laying out security and test.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private DaoAuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(
                        requests -> requests.requestMatchers(AUTHORIZED_REQUESTS).permitAll()
                                .requestMatchers(GUEST_REQUESTS).hasRole("ROLE_GUEST")
                                .requestMatchers(USER_REQUESTS).hasRole("ROLE_USER")
                                .requestMatchers(ADMIN_REQUESTS).hasRole("ROLE_ADMIN")
                                .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider);

        return http.build();
    }
}
