package br.com.zup.calculo_imposto.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private String UserName;
    private String password;
    private Role role;

    public UsuarioDTO(String userName, String password, Role role) {

        this.userName = userName;
        this.password = password;
        this.role = role;

    }
    public UsuarioDTO() {

    }
}
