package br.com.fiap.coleta.controller;

import br.com.fiap.coleta.dto.LoginDto;
import br.com.fiap.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.coleta.model.Usuario;
import br.com.fiap.coleta.service.TokenService;
import br.com.fiap.coleta.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthentication =
                new UsernamePasswordAuthenticationToken(
                        loginDto.cpf(),
                        loginDto.senha()
                );
        Authentication auth = authenticationManager.authenticate(usernamePasswordAuthentication);
        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioCadastroDto usuarioCadastroDto) {
        UsuarioExibicaoDto usuarioSalvo = usuarioService.cadastrarUsuario(usuarioCadastroDto);
        return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
    }
}
