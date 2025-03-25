package br.com.zup.calculo_imposto.Infra;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Component
public class JwtUtil {

    private Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username, List<String> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // horas
                .signWith(SECRET_KEY)
                .compact();
    }

    public String extractUserName(String token) {
        return extractUserName(token, claims::getSubject);
    }

    public <T> T extractClaim(String token, ClaimsResolver<T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.resolve(claims);
    }
    public interface ClaimsResolver<T> {
        T resolve(Claims claims);
    }
    public Claims extractAllClaims(String token) {
        JwtParser parser = Jwts.parser().setSigningKey(SECRET_KEY).build();
        return parser.parseClaimsJws(token).getBody();
    }
    public String getUserNameFromToken(String token) {
        return extractAllClaims(token).getSubject();
    }
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

}
