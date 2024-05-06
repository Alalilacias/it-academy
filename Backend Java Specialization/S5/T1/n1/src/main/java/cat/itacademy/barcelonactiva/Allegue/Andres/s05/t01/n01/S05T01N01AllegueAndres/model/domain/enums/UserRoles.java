package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.domain.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public enum UserRoles {
    ADMIN,
    USER;

    public List<SimpleGrantedAuthority> getAuthority(){
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.name()));
    }
}
