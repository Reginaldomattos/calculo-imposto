package br.com.zup.calculo_imposto.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UsuarioResponseDTOTest {

    private Long id;
    private String userName;
    private Role role;
    private UsuarioResponseDTO usuarioResponseDTO;

    @BeforeEach
    public void setUp() {
        id = 1L;
        userName = "testeUsuario";
        role = Role.Role_USER;

        usuarioResponseDTO = new UsuarioResponseDTO(id, userName, role);
    }
    @Test
    public void usuarioResponseDTOTest() {
        assertEquals(1L, usuarioResponseDTO.getId());
        assertEquals("testeUsuario", usuarioResponseDTO.getUserName());
        assertEquals(role, usuarioResponseDTO.getRole());
    }
}
