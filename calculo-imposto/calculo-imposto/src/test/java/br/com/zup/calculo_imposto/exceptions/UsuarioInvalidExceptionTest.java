package br.com.zup.calculo_imposto.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UsuarioInvalidExceptionTest {

    private String message;
    private UsuarioInvalidException exception;

    @BeforeEach
    public void setUp() {
        message = "Usuario invalido";

        exception = new UsuarioInvalidException(message);
    }

    @Test
    public void usuarioInvalidExceptionTest() {
        assertEquals(message, exception.getMessage());
    }
}
