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
    private RotaService rotaService;

    @PostMapping("/rotas/gravar")
    public ResponseEntity<Void> gravar(@RequestBody @Valid RotaDto dto) {
        rotaService.gravar(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/rotas/listar")
    public ResponseEntity<List<RotaDto>> listar() {
        return new ResponseEntity<>(rotaService.listar(), HttpStatus.OK);
    }

    @PutMapping("/rotas/atualizar")
    public ResponseEntity<Void> atualizar(@RequestBody @Valid RotaDto dto) {
        rotaService.atualizar(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/rotas/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        rotaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
