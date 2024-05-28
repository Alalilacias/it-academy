package com.api.fortuna.model.repository;

import com.api.fortuna.model.domain.Player;
import com.api.fortuna.model.domain.enums.Roles;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PlayerRepositoryTest {

    @MockBean
    private PlayerRepository repository;

    @Test
    void findPlayerByEmail() {
        String username = "test username";
        String email = "test@email.cat";
        String password = "testPassword";

        when(repository.findPlayerByEmail(email))
                .thenReturn(Optional.of(Player.builder()
                                .username(username)
                                .email(email)
                                .role(Roles.USER)
                                .password(password)
                        .build()));

        Optional<Player> optional = repository.findPlayerByEmail(email);

        assertTrue(optional.isPresent());
        assertEquals(username, optional.get().getUserPersonalName());
        assertEquals(email, optional.get().getEmail());
        assertEquals(password, optional.get().getPassword());
        assertEquals(Roles.USER, optional.get().getRole());
        assertEquals(Collections.singleton(new SimpleGrantedAuthority("ROLE_" + Roles.USER.name())).toArray()[0], optional.get().getAuthorities().toArray()[0]);
        assertEquals(0, optional.get().getDefeats());
        assertEquals(0, optional.get().getVictories());
        assertEquals(0, optional.get().getWinRate());
    }
}