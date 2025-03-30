package br.com.zup.calculo_imposto.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "USUARIO")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Nome é obrigatório")
    private String username;
    @NotBlank(message = "Senha é obrigatória")
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Usuario(Long id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public Usuario() {

    }
}
