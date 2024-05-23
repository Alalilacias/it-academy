package com.api.fortuna.configuration.filters;

import com.api.fortuna.model.service.FortunaTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.security.core.context.SecurityContextHolder.clearContext;

@ExtendWith(MockitoExtension.class)
class TokenFilterTest {
    @Mock
    private UserDetailsService detailsService;
    @Mock
    private FortunaTokenService tokenService;
    @Mock
    private FilterChain filterChain;

    @InjectMocks
    private TokenFilter tokenFilter;

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    private final String email = "test@user.com";
    private final UserDetails userDetails = mock(UserDetails.class);

    @BeforeEach
    void setUp() {
        clearContext();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test   // Valid Token
    void doFilterInternal() throws ServletException, IOException {
        request.addHeader("authorization", "Bearer validationToken");

        when(tokenService.getUsername("validationToken")).thenReturn(email);
        when(detailsService.loadUserByUsername(email)).thenReturn(userDetails);
        when(userDetails.getUsername()).thenReturn(email);
        when(tokenService.validateToken("validationToken", userDetails)).thenReturn(true);

        tokenFilter.doFilterInternal(request, response, filterChain);

        verify(tokenService).getUsername("validationToken");
        verify(detailsService).loadUserByUsername(email);
        verify(tokenService).validateToken("validationToken", userDetails);
        assertNotNull(SecurityContextHolder.getContext().getAuthentication());
        assertEquals(email, SecurityContextHolder.getContext().getAuthentication().getName());
        verify(filterChain).doFilter(request, response);
    }
    @Test   // No Authorization Header
    void doNoAuthorizationHeader() throws ServletException, IOException {
        tokenFilter.doFilterInternal(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }
    @Test   // Invalid Authorization Header
    void doInvalidAuthorizationHeader() throws ServletException, IOException {
        request.addHeader("authorization", "invalidTokenWithoutBearerTag");

        tokenFilter.doFilterInternal(request, response, filterChain);

        verify(filterChain).doFilter(request, response);
        assertNull(SecurityContextHolder.getContext().getAuthentication());
    }
    @Test   // Invalid Token
    void doInvalidToken() throws ServletException, IOException {
        request.addHeader("authorization", "Bearer invalidTokenBecauseWeNeedToTestIt");

        when(tokenService.getUsername("invalidTokenBecauseWeNeedToTestIt")).thenReturn(email);
        when(detailsService.loadUserByUsername(email)).thenReturn(userDetails);
        when(tokenService.validateToken("invalidTokenBecauseWeNeedToTestIt", userDetails)).thenReturn(false);

        tokenFilter.doFilterInternal(request, response, filterChain);

        verify(tokenService).getUsername("invalidTokenBecauseWeNeedToTestIt");
        verify(detailsService).loadUserByUsername(email);
        verify(tokenService).validateToken("invalidTokenBecauseWeNeedToTestIt", userDetails);
        assertNull(SecurityContextHolder.getContext().getAuthentication());
        verify(filterChain).doFilter(request, response);
    }
}