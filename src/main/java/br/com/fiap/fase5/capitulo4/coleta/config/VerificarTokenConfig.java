package br.com.fiap.fase5.capitulo4.coleta.config;

import br.com.fiap.fase5.capitulo4.coleta.security.VerificarToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VerificarTokenConfig {

    @Bean
    public VerificarToken verificarToken() {
        return new VerificarToken();
    }
}
