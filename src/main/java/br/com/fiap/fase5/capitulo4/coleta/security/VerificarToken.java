package br.com.fiap.fase5.capitulo4.coleta.security;

import br.com.fiap.fase5.capitulo4.coleta.repository.UsuarioRepository;
import br.com.fiap.fase5.capitulo4.coleta.service.auth.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class VerificarToken extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    ) throws ServletException, IOException {
        String verificarTokenGerado = request.getHeader("Authorization");
        String token = "";

        if(verificarTokenGerado == null) {
            token = null;
        } else {
            token = verificarTokenGerado.replace("Bearer", "").trim();
            String cpfValido = tokenService.validarToken(token);
            UserDetails usuario = usuarioRepository.findUsuarioByCpf(cpfValido);
            UsernamePasswordAuthenticationToken tokenAuth =
                    new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(tokenAuth);
        }
        filterChain.doFilter(request, response);
    }
}
