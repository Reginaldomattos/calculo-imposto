package br.com.zup.calculo_imposto.dtos;

import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioLoginDTOTest {

    private String userName;
    private String password;
    private UsuarioLoginDTO usuarioLoginDTO;

    @BeforeEach
    public void setUp() {
        userName = "TesteUsuario";
        password = "password";

        usuarioLoginDTO = new UsuarioLoginDTO(userName,password);
    }
    @Test
    public void usuarioLoginDTOTest() {
        assertEquals("TesteUsuario", usuarioLoginDTO.getUserName());
        assertEquals("password", usuarioLoginDTO.getPassword());
    }
    @Data
    public class UsuarioLoginDTO {
        private String userName;
        private String password;

        public br.com.zup.calculo_imposto.dtos.UsuarioLoginDTO(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }
        public br.com.zup.calculo_imposto.dtos.UsuarioLoginDTO() {

        }
    }
}
