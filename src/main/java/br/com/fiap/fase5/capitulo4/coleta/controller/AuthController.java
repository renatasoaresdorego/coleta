package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.LoginDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Usuario;
import br.com.fiap.fase5.capitulo4.coleta.service.UsuarioService;
import br.com.fiap.fase5.capitulo4.coleta.service.auth.TokenService;
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
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authManager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDto dto) {
        UsernamePasswordAuthenticationToken usernamePassword
                = new UsernamePasswordAuthenticationToken(dto.cpf(), dto.senha());
        Authentication auth = authManager.authenticate(usernamePassword);
        String token = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/cadastro")
    public ResponseEntity cadastrar(@RequestBody @Valid UsuarioCadastroDto dto) {
        return new ResponseEntity(usuarioService.cadastrar(dto), HttpStatus.CREATED);
    }

}
