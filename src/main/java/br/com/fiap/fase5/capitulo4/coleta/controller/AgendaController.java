package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
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
    private AgendaService service;

    @GetMapping("/agenda/agendamentos")
    public ResponseEntity<List<AgendaDto>> listarAgendamentos() {
        return new ResponseEntity<>(service.agendamentos(), HttpStatus.OK);
    }

    @PostMapping("/agenda/agendar-coleta")
    public ResponseEntity<Void> agendarColeta(@Valid @RequestBody AgendaDto dto) {
        service.agendarColeta(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/agenda/concluir-coleta")
    public ResponseEntity<Void> concluirColeta(@Valid @RequestBody AgendaDto dto) {
        service.concluirColeta(dto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("agenda/suspender-coleta")
    public ResponseEntity<Void> suspenderColeta(@Valid @RequestBody String id) {
        service.suspenderColeta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
