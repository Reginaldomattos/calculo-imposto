package br.com.zup.calculo_imposto.infra;

import br.com.zup.calculo_imposto.Infra.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.Key;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class JwtUtilTest {

    @InjectMocks
    private JwtUtil jwtUtil;

    private Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private String token;
    private String userName;
    private List<String> roles;
    private Date now;
    private Date expiration;

    @BeforeEach
    void setUp() {
        userName = "testUser";
        roles = Arrays.asList("ROLE_USER", "ROLE_ADMIN");
        now = new Date();
        expiration = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
        token = jwtUtil.geradorToken(userName, roles);
    }
    @Test
    void extractUserName_validToken_returnsUserName() {
        String extractedUserName = jwtUtil.extractUserName(token);
        assertEquals(userName, extractedUserName);
    }
    @Test
    void extractClaim_validTokenAndClaimsResolver_returnsClaim() {
        String extractedUserName = jwtUtil.extractClaim(token, Claims::getSubject);
        assertEquals(userName, extractedUserName);
    }
    @Test
    void getUserNameFromToken_validToken_returnsUserName() {
        String extractedUserName = jwtUtil.getUserNameFromToken(token);
        assertEquals(userName, extractedUserName);
    }
    @Test
    void validateToken_validToken_returnsTrue() {
        assertTrue(jwtUtil.validateToken(token));
    }
    @Test
    void isTokenExpired_validToken_returnsFalse() {
        assertFalse(jwtUtil.isTokenExpired(token));
    }

}
