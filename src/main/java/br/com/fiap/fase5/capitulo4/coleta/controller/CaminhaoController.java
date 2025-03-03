package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoDto;
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

    @GetMapping("caminhoes/{id}")
    public ResponseEntity<CaminhaoDto> buscarCaminhao(@PathVariable String id) {
        return new ResponseEntity<>(service.buscar(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CaminhaoDto>> listarCaminhoes() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @PostMapping("caminhoes/cadastrar-caminhao")
    public ResponseEntity<Void> cadastrarCaminhao(@Valid @RequestBody CaminhaoDto dto) {
        service.cadastrar(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("caminhoes/atualizar-caminhao")
    public ResponseEntity<Void> atualizarCaminhao(@Valid @RequestBody CaminhaoDto dto) {
        service.atualizar(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("caminhoes/excluir-caminhao/{id}")
    public ResponseEntity<Void> excluirCaminhao(@PathVariable String id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
