package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/coleta")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PutMapping("/usuario/atualizar-dados")
    public ResponseEntity<Void> atualizar(UsuarioCadastroDto dto) {
        service.atualizar(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
