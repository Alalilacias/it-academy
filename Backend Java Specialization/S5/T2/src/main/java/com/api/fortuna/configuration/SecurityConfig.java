package com.api.fortuna.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private DaoAuthenticationProvider authenticationProvider;

    private static final String[] AUTHORIZED_REQUESTS = {
            "/public/**",
            "/auth/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(
                        requests -> requests.requestMatchers(AUTHORIZED_REQUESTS).permitAll()
                                .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider);

        return http.build();
    }
}
