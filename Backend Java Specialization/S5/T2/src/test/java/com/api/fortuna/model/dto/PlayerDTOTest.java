package com.api.fortuna.model.dto;

import com.api.fortuna.model.domain.enums.Roles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerDTOTest {
    private final long id = 0;
    private final String username = "dto_test";
    private final Roles role = Roles.ADMIN;
    private final float winRate = 0.25f;

    private final PlayerDTO dto = new PlayerDTO(id, username, role, winRate);

    @Test
    void id() {
        assertEquals(id, dto.id());
    }

    @Test
    void username() {
        assertEquals(username, dto.username());
    }

    @Test
    void roles() {
        assertEquals(role, dto.roles());
    }

    @Test
    void winRate() {
        assertEquals(winRate, dto.winRate());
    }
}