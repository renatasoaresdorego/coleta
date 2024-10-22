package br.com.fiap.coleta.controller;

import br.com.fiap.coleta.dto.CaminhaoCadastroDto;
import br.com.fiap.coleta.model.Caminhao;
import br.com.fiap.coleta.service.CaminhaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;

    @PostMapping("/caminhao")
    @ResponseStatus(HttpStatus.CREATED)
    public Caminhao gravar(@RequestBody @Valid CaminhaoCadastroDto caminhaoCadastroDto) {
        return caminhaoService.gravar(caminhaoCadastroDto);
    }

    @PutMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    public Caminhao atualizar(@RequestBody @Valid Caminhao caminhao){
        return caminhaoService.atualizar(caminhao);
    }

    @GetMapping("/caminhao")
    @ResponseStatus(HttpStatus.OK)
    public List<Caminhao> listarTodosOsCaminhoes(){
        return caminhaoService.listarTodosOsCaminhoes();
    }

    @DeleteMapping("caminhao/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        caminhaoService.excluir(id);
    }
}
