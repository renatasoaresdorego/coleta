package br.com.fiap.fase5.capitulo4.coleta.controller;

import br.com.fiap.fase5.capitulo4.coleta.dto.RotaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Rota;
import br.com.fiap.fase5.capitulo4.coleta.service.RotaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/coleta")
public class RotaController {

    private RotaService rotaService;

    @PostMapping("/rota/gravar-rota")
    @ResponseStatus(HttpStatus.CREATED)
    public void gravarRota(@RequestBody @Valid RotaDto dto) {
        rotaService.gravar(dto);
    }

    @PutMapping("/rota/atualizar-rota")
    @ResponseStatus(HttpStatus.OK)
    public void atualizarRota(@RequestBody @Valid RotaDto dto) {
        rotaService.atualizar(dto);
    }

    @GetMapping("/rota/lista-de-rotas")
    @ResponseStatus(HttpStatus.OK)
    public List<Rota> listarRotas() {
        return rotaService.listar();
    }

    @DeleteMapping("/rota/excluir-rota/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        rotaService.excluir(id);
    }

}
