package cat.itacademy.barcelonactiva.Allegue.Andres.s05.t01.n01.S05T01N01AllegueAndres.model.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PublicKey;
import java.util.function.Function;

@Service
public class JwtService {
    private final String SECRET_KEY = "z()^a+i9p($!!^9^78zppx#@gq314i@@ip*8-7qy68i+vwyr$s";

    public String getUsername(String token){
        return getClaim(token, Claims::getSubject);
    }
    public boolean validateToken(String token, UserDetails userDetails){
        return false;
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = getAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    private Claims getAllClaims(String token){
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSigningKey() {
        return null;
    }
}
