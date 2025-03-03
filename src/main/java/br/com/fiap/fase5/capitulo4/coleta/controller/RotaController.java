package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.RotaDto;
import br.com.fiap.fase5.capitulo4.coleta.service.RotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/coleta")
public class RotaController {

    @Autowired
    private RotaService service;

    @PostMapping("/rota/gravar-rota")
    public ResponseEntity<Void> gravarRota(@RequestBody @Valid RotaDto dto) {
        service.gravar(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/rota/lista-de-rotas")
    public ResponseEntity<List<RotaDto>> listarRotas() {
        return new ResponseEntity<>(service.listar(), HttpStatus.OK);
    }

    @PutMapping("/rota/atualizar-rota")
    public ResponseEntity<Void> atualizarRota(@RequestBody @Valid RotaDto dto) {
        service.atualizar(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/rota/excluir-rota/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        service.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
