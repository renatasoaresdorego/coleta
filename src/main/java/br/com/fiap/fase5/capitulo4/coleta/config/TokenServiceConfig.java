package br.com.fiap.fase5.capitulo4.coleta.config;

import br.com.fiap.fase5.capitulo4.coleta.service.auth.TokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenServiceConfig {

    @Bean
    public TokenService tokenService() {
        return new TokenService();
    }
}
