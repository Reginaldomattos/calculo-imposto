package br.com.zup.calculo_imposto.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RoleInvalidExceptionTest {
    private String message;
    private RoleInvalidException exception;

    @BeforeEach
    public void setUp() {
        message = "ROLE_ADMIN E ROLE_USER";

        exception = new RoleInvalidException(message);

    }
    @Test
    public void roleInvalidExceptionTeste() {
        assertEquals(message, exception.getMessage());
    }
}
