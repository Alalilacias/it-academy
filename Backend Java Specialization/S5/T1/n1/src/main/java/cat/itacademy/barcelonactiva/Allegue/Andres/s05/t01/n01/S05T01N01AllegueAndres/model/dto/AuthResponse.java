package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.dto;

import lombok.Builder;

@Builder
public record AuthResponse(
        String token,
        boolean alreadyRegisteredUsername,
        boolean alreadyRegisteredEmail,
        boolean userRegistered,
        boolean user_authenticated
) {}
