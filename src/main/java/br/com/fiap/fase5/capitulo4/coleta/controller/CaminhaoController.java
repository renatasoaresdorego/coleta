package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/coleta")
public class CaminhaoController {

    @Autowired
    private CaminhaoService service;

    @GetMapping("/caminhoes/buscar/{placa}")
    public ResponseEntity<CaminhaoExibicaoDto> buscar(@PathVariable String placa) {
        return new ResponseEntity<>(service.buscar(placa), HttpStatus.OK);
    }

    @GetMapping("/caminhoes/listar")
    public ResponseEntity<List<CaminhaoExibicaoDto>> listar() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @PostMapping("/caminhoes/cadastrar-caminhao")
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody CaminhaoDto dto) {
        service.cadastrar(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/caminhoes/atualizar-caminhao")
    public ResponseEntity<Void> atualizar(@Valid @RequestBody CaminhaoDto dto) {
        service.atualizar(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/caminhoes/excluir-caminhao/{placa}")
    public ResponseEntity<Void> excluir(@PathVariable String placa) {
        service.excluir(placa);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
