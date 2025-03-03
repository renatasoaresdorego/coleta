package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.service.PontoDeColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/coleta")
public class PontoDeColetaController {

    @Autowired
    private PontoDeColetaService pontoDeColetaService;

    @PostMapping("/pontos-de-coleta/cadastrar")
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid PontoDeColetaCadastroDto dto) {
        pontoDeColetaService.cadastrar(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/pontos-de-coleta/listar")
    public ResponseEntity<List<PontoDeColetaExibicaoDto>>listar() {
        return new ResponseEntity<>(pontoDeColetaService.listar(), HttpStatus.OK);
    }

    @PutMapping("/pontos-de-coleta/atualizar")
    public ResponseEntity<Void> atualizar(@RequestBody @Valid PontoDeColetaCadastroDto dto) {
        pontoDeColetaService.atualizar(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/pontos-de-coleta/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        pontoDeColetaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
