package com.api.fortuna.model.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Service implementation for managing token entities and related operations.
 */
@Service
public class FortunaTokenService {
    @Value("${fortuna.token.key}")
    private String key;
    @Value("${fortuna.token.expiration}")
    private long expiration;

    /**
     * Generates a JWT token with the provided user details.
     *
     * @param details the UserDetails object representing the user.
     * @return the generated JWT token as a String.
     */
    public String generateToken(UserDetails details){
        return generateToken(new HashMap<>(), details);
    }

    /**
     * Generates a JWT token with the provided claims and user details.
     *
     * @param claims a map of claims to be included in the JWT token
     * @param details the UserDetails object representing the user
     * @return the generated JWT token as a String
     */
    public String generateToken(Map<String, Object> claims, UserDetails details){
        return Jwts.builder()
                .claims(claims)
                .subject(details.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey())
                .compact();
    }

    /**
     * Validates the token, making sure the username and expiration dates are valid.
     *
     * @param token the JWT token.
     * @param userDetails the UserDetails representing the user.
     * @return {@code true} if the token is valid and corresponds to the given user, {@code false} otherwise
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Reads the expiration date and confirms if it's expired at the time of reading.
     *
     * @param token the JWT token.
     * @return {@code true} if the token is expired, {@code false} otherwise
     */
    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

    /**
     * Extracts the expiration date from the given JWT token.
     *
     * @param token the JWT token.
     * @return the expiration date contained in the token.
     */
    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts the username from the given JWT token.
     *
     * @param token the JWT token
     * @return the username (subject) contained in the token
     */
    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    /**
     * Retrieves a specific claim from the given JWT token using the provided claims resolver function.
     *
     * @param token the JWT token
     * @param claimsFunction function to retrieve a claim from the token
     * @param <T> the type of the claim to be returned
     * @return the claim resolved by the provided function
     */
    private <T> T getClaim(String token, Function<Claims, T> claimsFunction) {
        final Claims claims = getAllClaims(token);
        return claimsFunction.apply(claims);
    }

    /**
     * Parses the given JWT token and retrieves all claims.
     *
     * @param token the JWT token
     * @return all claims contained in the token
     */
    private Claims getAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Generates the signing key from the base64-encoded key string.
     *
     * @return the signing key
     */
    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}