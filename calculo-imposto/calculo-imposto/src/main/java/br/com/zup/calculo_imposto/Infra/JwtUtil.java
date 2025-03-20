package br.com.zup.calculo_imposto.Infra;

import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.List;

public class JwtUtil {

    private static final String SECRET_KEY = "secret";

    public static String generateToken(String username) {
        List<String> permissions = List.of("ROLE_USER", "ROLE_ADMIN");

        return Jwts.builder()
                .setSubject(username)
                .claim("permissions", permissions)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // horas
                .signWith(signatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
}
