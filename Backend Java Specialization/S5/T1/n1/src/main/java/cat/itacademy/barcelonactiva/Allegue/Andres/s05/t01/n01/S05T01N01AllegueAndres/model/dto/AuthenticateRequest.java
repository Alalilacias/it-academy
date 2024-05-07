package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services.UserServiceImplemented;
import org.springframework.security.core.userdetails.UserDetails;

public record AuthenticateRequest(String username, String password) {
    public UserDetails toUserDetails(){
        return UserServiceImplemented.convertToNonDTO(this);
    }
}
