/*
package com.myapp.SuiviCredit.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Inject secret key from application.properties
    @Value("${jwt.secret-key}")
    private String SECRET_KEY;

    // Expire time for token (e.g., 24 hours)
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    // Convert the secret string into a Key object
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // Generate a token for a username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)                     // Put username in the token
                .setIssuedAt(new Date())                 // Token creation time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Expiry
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Sign the token
                .compact();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    // Check if token is expired
    public boolean isTokenExpired(String token) {
        return parseToken(token).getBody().getExpiration().before(new Date());
    }

    // Validate token: correct username and not expired
    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // Parse the token to get its claims (data)
    private Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey()) // Use the same key
                .build()
                .parseClaimsJws(token);
    }
}


 */