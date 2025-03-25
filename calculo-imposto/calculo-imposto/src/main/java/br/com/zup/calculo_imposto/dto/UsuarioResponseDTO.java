package br.com.zup.calculo_imposto.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

    private Long id;
    private String userName;
    private Role role;

    public UsuarioResponseDTO() {

    }

    public UsuarioResponseDTO(Long id, String userName, Role role) {

        this.id = id;
        this.userName = userName;
        this.role = role;
    }
}
