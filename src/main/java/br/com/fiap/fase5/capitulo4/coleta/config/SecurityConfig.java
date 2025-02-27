package br.com.fiap.fase5.capitulo4.coleta.config;

import br.com.fiap.fase5.capitulo4.coleta.model.Usuario;
import br.com.fiap.fase5.capitulo4.coleta.repository.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UsuarioRepository usuarioRepository;

    @Bean
    public SecurityFilterChain filtroDeSeguranca(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.POST, "/api/v2/auth/login").hasAnyRole("ADMIN","USER")
                .requestMatchers(HttpMethod.POST, "/api/v2/auth/cadastro").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v2/coleta/rota").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v2/coleta/rota").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/v2/coleta/rota").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/v2/coleta/rota/").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
        .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return cpf -> {
            Usuario usuario = usuarioRepository.findByCpf(cpf)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o CPF: " + cpf));
            return usuario;
        };
    }

}
