package com.api.fortuna.model.domain;

import com.api.fortuna.model.domain.enums.Roles;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerSqlTest {
    Player player = Player.builder()
            .id(0L)
            .username("Test_Player")
            .password("test_password")
            .role(Roles.GUEST)
            .victories(50)
            .defeats(15)
            .build();

    @Test
    void testBuilder() {
        assertNotNull(player);
        assertEquals(0L, player.getId());
        assertEquals("Test_Player", player.getUsername());
        assertEquals("test_password", player.getPassword());
        assertEquals(Roles.GUEST, player.getRole());
        assertEquals(50, player.getVictories());
        assertEquals(15, player.getDefeats());
    }

    @Test
    public void testGetAuthorities() {
        Roles role = mock(Roles.class);
        when(role.getAuthorities()).thenReturn(mock(Collection.class));

        Player player = Player.builder()
                .role(role)
                .build();

        Collection<? extends GrantedAuthority> authorities = player.getAuthorities();
        assertNotNull(authorities);
        verify(role, times(1)).getAuthorities();
    }

    @Test
    public void testUserDetailsMethods() {
        Player player = new Player();

        assertTrue(player.isAccountNonExpired());
        assertTrue(player.isAccountNonLocked());
        assertTrue(player.isCredentialsNonExpired());
        assertTrue(player.isEnabled());
    }

    @Test
    public void testGettersAndSetters() {
        Player player = new Player();
        player.setId(1L);
        player.setUsername("test_user");
        player.setPassword("test_pass");
        player.setRole(Roles.USER);
        player.setVictories(10);
        player.setDefeats(5);

        assertEquals(1L, player.getId());
        assertEquals("test_user", player.getUsername());
        assertEquals("test_pass", player.getPassword());
        assertEquals(Roles.USER, player.getRole());
        assertEquals(10, player.getVictories());
        assertEquals(5, player.getDefeats());
    }
}