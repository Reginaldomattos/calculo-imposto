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
        //codifica a senha antes de salvar
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        // Salva o usuário no banco de dados
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        // Retorna todos os usuários do banco de dados
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        // Busca um usuário pelo ID
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + id));
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        // Busca o usuário existente
        Usuario usuarioExistente = buscarPorId(id);

        // Atualiza os campos do usuário
        usuarioExistente.setUsername(usuarioAtualizado.getUsername());
        usuarioExistente.setPassword(passwordEncoder.encode(usuarioAtualizado.getPassword()));
        usuarioExistente.setRole(usuarioAtualizado.getRole());

        // Salva as alterações no banco de dados
        return usuarioRepository.save(usuarioExistente);
    }

    public void deletarUsuario(Long id) {
        // Verifica se o usuario existe antes de deletar
        Usuario usuario = buscarPorId(id);

        //Remove o usuário do banco de dados
        usuarioRepository.delete(usuario);
    }
}