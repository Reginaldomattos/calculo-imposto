package br.com.zup.calculo_imposto.exceptions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UsuarioNotFoundExceptionTest {

    private String message;
    private UsuarioNotFoundException exception;

    @BeforeEach
    public void setUp() {
        message = "Usuario nao encontrado";

        exception = new UsuarioNotFoundException(message);


    }
    @Test
    public void usuarioNotFoundExceptionTest() {
        assertEquals(message, exception.getMessage());
    }

}
