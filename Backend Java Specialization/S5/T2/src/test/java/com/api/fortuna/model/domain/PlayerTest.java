package com.api.fortuna.model.domain;

import com.api.fortuna.model.domain.enums.Roles;
import com.api.fortuna.model.dto.PlayerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit Test class of the Player class.
 */
class PlayerTest {
    /**
     * Player instance, used for testing.
     */
    Player player = Player.builder()
            .username("Test_Player")
            .email("test@email.com")
            .password("test_password")
            .role(Roles.GUEST)
            .build();

    /**
     * PlayerDTO instance, expected to be equal to the result of player.toDto().
     */
    PlayerDTO playerDTO = new PlayerDTO(null, "Test_Player", Roles.GUEST, 0);

    /**
     * Tests Lombok Builder class implementation's correct functioning.
     */
    @Test
    void builder() {
        assertNotNull(player, "Player object should not be null.");
    }

    /**
     * Tests getAuthorities() method.
     * It mocks the Role Class, returns a mock of the Collection Class and then ensures the method doesn't return null and is invoked at least once.
     */
    @Test
    void getAuthorities() {
        Roles role = mock(Roles.class);
        //noinspection unchecked
        when(role.getAuthorities()).thenReturn(mock(Collection.class));

        Player player = Player.builder()
                .role(role)
                .build();

        Collection<? extends GrantedAuthority> authorities = player.getAuthorities();
        assertNotNull(authorities, "Authorities should not be null.");
        verify(role, times(1)).getAuthorities();
    }

    /**
     * Tests the UserDetails methods to ensure they return the results they're coded to.
     */
    @Test
    void getPassword() {
        assertEquals("test_password", player.getPassword(), "Password should match original value.");
    }

    @Test
    void isAccountNonExpired() {
        assertTrue(player.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        assertTrue(player.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        assertTrue(player.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {
        assertTrue(player.isEnabled());
    }

    /**
     * Tests the toDTO() method to ensure it returns the DTO equivalent of the class.
     */
    @Test
    void toDTO() {
        assertEquals(playerDTO, player.toDTO());
    }

    /**
     * Tests the Getters and Setters.
     */
    @Test
    void getId() {
        assertNull(player.getId(), "Id variable should be null before being saved to database.");
    }

    @Test
    void getUsername() {
        assertEquals("Test_Player", player.getUsername(), "Username should match original value.");
    }

    @Test
    void getEmail() {
        assertEquals("test_password", player.getPassword(), "Password should match original value.");
    }

    @Test
    void getRole() {
        assertEquals(Roles.GUEST, player.getRole(), "Role should match original value.");
    }

    @Test
    void getDefeats() {
        assertEquals(0, player.getDefeats(), "Defeats should be 0.");
    }

    @Test
    void getVictories() {
        assertEquals(0, player.getVictories(), "Victories should be 0.");
    }

    @Test
    void getWinRate() {
        assertEquals(0, player.getWinRate(), "Win Rate should be 0.");
    }

    @Test
    void setUsername() {
        String username = "test_user";
        player.setUsername(username);
        assertEquals(username, player.getUsername(), "Username should match the value that was introduced to it's setter.");
    }

    /**
     * Tests addResult() method.
     */
    @Test
    void addResult() {
        player.addResult(true);
        assertEquals(1f, player.getWinRate());
        player.addResult(false);
        assertEquals(0.5f, player.getWinRate());
    }
}