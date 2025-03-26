package br.com.zup.calculo_imposto.config;

import br.com.zup.calculo_imposto.Infra.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
                .requestMatchers("/user/cadastrar", "/user/login").permitAll()
                .requestMatchers(HttpMethod.POST,"/tipos", "tipos/calculo").hasAnyAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.GET,"/tipos").authenticated()
                .qualquerRequisicao().autenticado()
        );
        http.csrf(AbstractHttpConfigurer::desabilitar);
        http.addFilterBefore(jwtAuthenticationFilter, Nome de usuarioSenhaAuthenticationFilter.class);


        return http.build();
    }


   @Bean
   public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
   }

}