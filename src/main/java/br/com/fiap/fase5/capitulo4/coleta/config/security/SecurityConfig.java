package br.com.fiap.fase5.capitulo4.coleta.config.security;

import br.com.fiap.fase5.capitulo4.coleta.auth.VerificarToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private VerificarToken verificarToken;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/cadastro").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v2/coleta/pontos-de-coleta/listar").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/v2/coleta/agenda/coletas-agendadas").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/v2/coleta/rotas/listar").hasRole("USER")
                        .requestMatchers(HttpMethod.PUT, "/api/v2/coleta/usuario/atualizar-dados").hasRole("USER")
                    .anyRequest().hasRole("ADMIN"))
                .addFilterBefore(verificarToken, UsernamePasswordAuthenticationFilter.class)
        .build();
    }

}
