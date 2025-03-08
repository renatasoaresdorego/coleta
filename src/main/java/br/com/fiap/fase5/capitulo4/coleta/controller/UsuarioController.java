package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioAtualizarDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.UsuarioExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/coleta")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/usuario/cadastro")
    public ResponseEntity<UsuarioExibicaoDto> cadastrar(@RequestBody @Valid UsuarioCadastroDto dto) {
        return new ResponseEntity<>(service.cadastrar(dto), HttpStatus.CREATED);
    }

    @GetMapping("/usuario/buscar-usuario/{cpf}")
    public ResponseEntity<UsuarioExibicaoDto> buscar(@PathVariable String cpf) {
        return new ResponseEntity<>(service.buscar(cpf), HttpStatus.OK);
    }

    @PutMapping("/usuario/atualizar-dados")
    public ResponseEntity<Void> atualizar(@RequestBody @Valid UsuarioAtualizarDto dto) {
        service.atualizar(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("usuario/excluir-usuario/{cpf}")
    public ResponseEntity<Void> excluir(@PathVariable String cpf) {
        service.excluir(cpf);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
