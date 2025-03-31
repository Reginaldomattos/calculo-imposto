package br.com.zup.calculo_imposto.controllers;

import br.com.zup.calculo_imposto.Infra.JwtUtil;
import br.com.zup.calculo_imposto.service_test.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UsuarioController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private UserDetailsService userDetailsService;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    public void setUp(){
        usuario = new Usuario("1", "TesteUsuario", "TestePassword", Role.ROLE_USER);
        usuarioDTO = new UsuarioDTO("TesteUsuario", "TestePassword", Role.ROLE_USER);

    }
    @Test
    public void cadastrarUsuarioTeste() throws Exception {
        when(usuarioService.cadastrarUsuario(any(UsuarioDTO.class))).thenReturn(usuario);

        String usuarioJson = """
                {
                     "userName": "TesteUsuario",
                     "password": "TestePassword",
                     "role": "ROLE_USER"
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/usuario/cadastrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(usuarioJson))
                .andDo(result -> System.out.println("Response: " + result.getResponse().getContentAsString()))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.uuid").value("1"))
                .andExpect(jsonPath("$.userName").value("TesteUsuario"))
                .andExpect(jsonPath("$.role").value("ROLE_USER"));

    }
    @Test
    public void loginSucessoTeste() throws Exception {
        String token = "mocked-jwt-token";

        when(usuarioService.login(any(UsuarioLoginDTO.class))).thenReturn(token);

        String loginUsuarioJson = """
                {
                    "userName": "TesteUsuario",
                    "password": "TestePassword"
                }
                """;

        mockMvc.perform(MockMvcRequestBuilders.post("/api/usuario/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginUsuarioJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value(token));

    }
    @Test
    public void login_Falha() throws Exception {
        // Arrange: Mock the service to throw a RuntimeException
        when(usuarioService.login(any(UsuarioLoginDTO.class))).thenThrow(new RuntimeException("Invalid credentials"));

        // JSON payload for the request
        String loginJson = """
            {
                "userName": "InvalidUser",
                "password": "InvalidPassword"
            }
            """;

        // Act and Assert: Perform POST request and validate error response
        mockMvc.perform(MockMvcRequestBuilders.post("/api/usuario/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(loginJson))
                .andExpect(status().isUnauthorized()) // HTTP 401 Unauthorized
                .andExpect(jsonPath("$.message").value("Invalid credentials")); // Validate error message




    
    }

}
