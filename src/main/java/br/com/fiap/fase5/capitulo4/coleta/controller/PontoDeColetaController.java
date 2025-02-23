package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaDto;
import br.com.fiap.fase5.capitulo4.coleta.service.PontoDeColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v2/coleta")
public class PontoDeColetaController {

    @Autowired
    private PontoDeColetaService service;

    @PostMapping("/pontos/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarPontoDeColeta(@Valid @RequestBody PontoDeColetaDto dto) {
        service.cadastrarPontoDeColeta(dto);
    }

    @GetMapping("/pontos/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<PontoDeColetaDto> listarPontosDeColeta() {
        return service.listar();
    }

    @DeleteMapping("/pontos/excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirPontoDeColeta(@PathVariable Long id) {
        service.excluir(id);
    }
}
