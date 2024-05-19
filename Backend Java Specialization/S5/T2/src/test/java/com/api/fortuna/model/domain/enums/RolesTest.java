package com.api.fortuna.model.domain.enums;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RolesTest {

    @Test
    void getAuthorities() {
        assertEquals(Collections.singletonList(new SimpleGrantedAuthority(("ROLE_GUEST"))), Roles.GUEST.getAuthorities());
        assertEquals(Collections.singletonList(new SimpleGrantedAuthority(("ROLE_USER"))), Roles.USER.getAuthorities());
        assertEquals(Collections.singletonList(new SimpleGrantedAuthority(("ROLE_ADMIN"))), Roles.ADMIN.getAuthorities());
    }

    @Test
    void values() {
        Roles[] values = Roles.values();
        assertEquals(Roles.GUEST, values[0]);
        assertEquals(Roles.USER, values[1]);
        assertEquals(Roles.ADMIN, values[2]);
    }

    @Test
    void valueOf() {
    }
}