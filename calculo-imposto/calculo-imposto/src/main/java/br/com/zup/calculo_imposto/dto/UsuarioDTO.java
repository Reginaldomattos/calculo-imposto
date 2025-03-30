package br.com.zup.calculo_imposto.dto;

import br.com.zup.calculo_imposto.models.Role;
import lombok.Data;

@Data
public class UsuarioDTO {

    private String userName;
    private String password;
    private Role role;


    public UsuarioDTO() {

    }

    public UsuarioDTO(String userName, String password, Role role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
}
