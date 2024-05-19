package com.api.fortuna.model.domain.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;

/**
 * Enum representing all possible user roles. Update in case the needs of the system.
 */
public enum Roles {
    GUEST,
    USER,
    ADMIN;

    /**
     * Returns a collection of simple granted authorities, using the name of the enum.
     *
     * @return a List of simple granted authorities, currently a singleton list is returned.
     * @see SimpleGrantedAuthority
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}