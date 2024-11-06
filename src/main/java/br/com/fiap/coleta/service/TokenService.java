package br.com.fiap.coleta.service;

import br.com.fiap.coleta.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String segredo;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(segredo);
            return JWT.create().withIssuer("coleta")
                    .withSubject(usuario.getCpf())
                    .withExpiresAt(Instant.from(LocalDateTime.now().plusHours(1)))
                    .sign(algoritmo);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Erro ao gerar o token de autenticação.");
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm algoritmo = Algorithm.HMAC256(segredo);
            return JWT.require(algoritmo).withIssuer("coleta").build().verify(token).getSubject();
        } catch(JWTVerificationException ex) {
            return "";
        }
    }
}
