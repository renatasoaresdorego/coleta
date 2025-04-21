package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaAtualizacaoDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.service.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/coleta")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/agenda/agendar-coleta")
    public ResponseEntity<Void> agendar(@RequestBody @Valid AgendaDto dto) {
        agendaService.agendar(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/agenda/coletas-agendadas")
    public ResponseEntity<List<AgendaExibicaoDto>> listar() {
        return new ResponseEntity<>(agendaService.agendamentos(), HttpStatus.OK);
    }

    @PutMapping("/agenda/concluir-coleta")
    public ResponseEntity<Void> concluir(@RequestBody AgendaAtualizacaoDto dto) {
        agendaService.concluir(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("agenda/suspender-coleta")
    public ResponseEntity<Void> suspender(@RequestBody @Valid String id) {
        agendaService.suspender(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("agenda/excluir-coleta-agendada/{id}")
    public ResponseEntity<Void> excluir(@PathVariable String id) {
        agendaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
