package br.com.zup.calculo_imposto.services;

import br.com.zup.calculo_imposto.models.Usuario;
import br.com.zup.calculo_imposto.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username)
                .map(usuario -> User.builder()
                        .username(usuario.getUsername())
                        .password(usuario.getPassword())
                        .roles(usuario.getRole())
                        .build())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o username: " + username));
    }

    public Usuario registrarUsuario(Usuario usuario) {
        // Verifica se o username já existe
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username já está em uso.");
        }

        // Codifica a senha antes de salvar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Salva o usuário no banco de dados
        return usuarioRepository.save(usuario);
    }

    public Usuario salvarUsuario(Usuario usuario) {
    }

    public List<Usuario> listarTodos() {
    }

    public Usuario buscarPorId(Long id) {
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
    }

    public void deletarUsuario(Long id) {
    }
}