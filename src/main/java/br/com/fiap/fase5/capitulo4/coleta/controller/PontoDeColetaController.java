package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaDto;
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
    private PontoDeColetaService service;

    @PostMapping("/pontos/cadastrar")
    public ResponseEntity<PontoDeColetaDto> cadastrarPontoDeColeta(@Valid @RequestBody PontoDeColetaDto dto) {
        service.cadastrarPontoDeColeta(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/pontos/listar")
    public ResponseEntity<List<PontoDeColetaDto>>listarPontosDeColeta() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @DeleteMapping("/pontos/excluir/{id}")
    public ResponseEntity<Void> excluirPontoDeColeta(@PathVariable String id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

}
