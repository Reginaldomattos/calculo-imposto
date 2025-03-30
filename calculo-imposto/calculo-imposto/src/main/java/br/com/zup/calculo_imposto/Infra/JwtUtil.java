package br.com.zup.calculo_imposto.Infra;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long expirationTime = 1000 * 60 * 60; // 1 hora

    public String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, java.util.function.Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims extractAllClaims(String token) {
        try {
            JwtParser parser = Jwts.builder()
                    .setSigningKey(secretKey)
                    .build();
            return parser.parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // Logar a exceção ou lançar uma exceção customizada, dependendo da necessidade
            return null; // ou lançar uma exceção
        }
    }

    public String getUsernameFromToken(String token) {
        Claims claims = extractAllClaims(token);
        if(claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    public boolean isTokenExpired(String token) {
        Claims claims = extractAllClaims(token);
        if(claims != null) {
            return claims.getExpiration().before(new Date());
        }
        return true;
    }
}
