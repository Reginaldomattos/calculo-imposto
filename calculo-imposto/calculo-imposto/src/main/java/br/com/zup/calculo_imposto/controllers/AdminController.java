package br.com.zup.calculo_imposto.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/Bem-Vindo")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String Bem_Vindo_Admin() {
        return "Bem-vindo, Administrador!";
    }
}
