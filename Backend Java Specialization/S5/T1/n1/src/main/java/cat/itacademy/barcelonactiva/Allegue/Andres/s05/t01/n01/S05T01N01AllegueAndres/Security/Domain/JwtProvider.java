package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.Security.Domain;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    @Value("${S05T01N01AllegueAndres.app.jwtSecret}")
    private String secret;

    @Value("${S05T01N01AllegueAndres.app.jwtExpirationMs}")
    private int expirationInMs;

    private String generateToken(Authentication authentication){
        return null;
    }
}
