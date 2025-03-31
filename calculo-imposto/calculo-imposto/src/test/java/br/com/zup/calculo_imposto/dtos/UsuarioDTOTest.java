package br.com.zup.calculo_imposto.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UsuarioDTOTest {

    private String userName;
    private String password;
    private Role role;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    public void setUp() {
        userName = "TesteUsuario";
        password = "password";
        role = Role.ROLE_USER;

        usuarioDTO = new UsuarioDTO((UserName, password, role));
    }
    @Test
    public void usuarioDTOTest() {
        assertEquals(userName, usuarioDTO.getUserName());
        assertEquals(password, usuarioDTO.getPassword());
        assertEquals(role, usuarioDTO.getRole());
    }

}
