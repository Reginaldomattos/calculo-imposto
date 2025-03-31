package br.com.zup.calculo_imposto.service;

import br.com.zup.calculo_imposto.Infra.JwtUtil;
import br.com.zup.calculo_imposto.repositorys.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;
    private UsuarioLoginDTO usuarioLoginDTO;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
        usuario.setUserName("testeUsuário");
        usuario.setPassword(new BCryptPasswordEncoder().encode("testePassword"));
        usuario.setRole(Role.ROLE_USER);
    }
    @Test
    public void cadastrarUsuarioTest() {
        when(usuarioRepository.findByUserName(anyString())).thenReturn(Optional.empty());
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        UsuarioDTO usuarioDTO = new UsuarioDTO("testeUsuario", "testePassword", Role.ROLE_USER);
        Usuario result = usuarioService.cadastrarUsuario(usuarioDTO);

        assertNotNull(result);
        assertEquals("testeUsuario", result.getUserName());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
    }
    @Test
    public void loginTeste() {
        when(usuarioRepository.findByUserName(anyString())).thenReturn(Optional.of(usuario))
        when(jwtUtil.geradorToken(anyString(), anyList())).thenReturn("Token");

        UsuarioLoginDTO usuarioLoginDTO = new UsuarioLoginDTO();
        usuarioLoginDTO.setUserName("testeUsuario");
        usuarioLoginDTO.setPassword("testePassword");

        String token = usuarioService.login(usuarioLoginDTO);

        assertEquals("Token", token);
    }
    @Test
    public void loadUserByUsernameTeste() {
        when(usuarioRepository.findByUserName(anyString())).thenReturn(Optional.of(usuario));

        UserDetails userDetails = usuarioService.loadUserByUsername("testeUsuario");

        assertNotNull(userDetails, "Usuario nao encontrado");
        assertEquals("testeUsuario", userDetails.getUsername());
        assertTrue(new BCryptPasswordEncoder().matches("testePassword", userDetails.getPassword()));
        assertEquals(Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),userDetails.getAuthorities());

    }
}
