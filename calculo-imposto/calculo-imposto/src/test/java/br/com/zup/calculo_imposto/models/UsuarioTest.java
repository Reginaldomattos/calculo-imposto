package br.com.zup.calculo_imposto.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UsuarioTest {

    @Test
    public void UsuarioTeste() {
        Usuario usuario = new Usuario("1", "testeUsuario", "testePassword", Role.ROLE_USER);

        assertEquals("1", usuario.getUuid());
        assertEquals("testeUsuario", usuario.getUserName());
        assertEquals("testePassword", usuario.getPassword());
        assertEquals(Role.ROLE_USER, usuario.getRole());
    }
}
