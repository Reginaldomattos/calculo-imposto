package br.com.zup.calculo_imposto.controllers;


import br.com.zup.calculo_imposto.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.registrarUsuario(usuario), HttpStatus.CREATED);

    }
}
