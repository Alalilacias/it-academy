package com.api.fortuna.configuration;

import com.api.fortuna.configuration.filters.TokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * TODO finish laying out security and test.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    private TokenFilter tokenFilter;
    @Autowired
    private AuthenticationProvider authenticationProvider;

    public static final String[] AUTHORIZED_REQUESTS = {"/", "/auth/**", "/public/**"};
    public static final String[] USER_REQUESTS = {"player/**"};
    public static final String[] ADMIN_REQUESTS = {"/admin/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(Customizer.withDefaults())
                .authorizeHttpRequests(
                        requests -> requests.requestMatchers(AUTHORIZED_REQUESTS).permitAll()
                                .requestMatchers(USER_REQUESTS).hasAnyAuthority("ROLE_USER")
                                .requestMatchers(ADMIN_REQUESTS).hasAnyAuthority("ROLE_ADMIN")
                                .anyRequest().authenticated())
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
