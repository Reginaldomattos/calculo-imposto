package br.com.zup.calculo_imposto.dto;

import lombok.Data;

@Data
public class UsuarioLoginDTO {

    private String userName;
    private String password;

    public UsuarioLoginDTO(String userName, String password) {

        this.UserName = UserName;
        this.password = password;
    }

    public UsuarioLoginDTO() {

    }
}
