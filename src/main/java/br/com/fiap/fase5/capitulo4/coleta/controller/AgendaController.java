package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
import br.com.fiap.fase5.capitulo4.coleta.service.AgendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/coleta")
public class AgendaController {

    @Autowired
    private AgendaService service;

    @GetMapping("/agenda/agendamentos")
    @ResponseStatus(HttpStatus.OK)
    public List<AgendaDto> listarAgendamentos() {
        return service.agendamentos();
    }

    @PostMapping("/agenda/agendar-coleta")
    @ResponseStatus(HttpStatus.CREATED)
    public void agendarColeta(@Valid @RequestBody AgendaDto dto) {
        service.agendarColeta(dto);
    }

    @PutMapping("/agenda/concluir-coleta")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void concluirColeta(@Valid @RequestBody AgendaDto dto) {
        service.concluirColeta(dto);
    }

    @PutMapping("agenda/suspender-coleta")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void suspenderColeta(@Valid @RequestBody Long id) {
        service.suspenderColeta(id);
    }

}
