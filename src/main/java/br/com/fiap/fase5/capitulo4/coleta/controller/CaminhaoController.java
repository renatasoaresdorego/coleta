package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoDto;
import br.com.fiap.fase5.capitulo4.coleta.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/coleta")
public class CaminhaoController {

    @Autowired
    private CaminhaoService service;

    @GetMapping("caminhoes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CaminhaoDto buscarCaminhao(@PathVariable String id) {
        return service.buscar(id);
    }

    @PostMapping("caminhoes/cadastrar-caminhao")
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCaminhao(@Valid @RequestBody CaminhaoDto dto) {
        service.cadastrar(dto);
    }

    @PutMapping("caminhoes/atualizar-caminhao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCaminhao(@Valid @RequestBody CaminhaoDto dto) {
        service.atualizar(dto);
    }

    @DeleteMapping("caminhoes/excluir-caminhao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirCaminhao(@PathVariable String id) {
        service.excluir(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CaminhaoDto> listarCaminhoes() {
        return service.listar();
    }

}
