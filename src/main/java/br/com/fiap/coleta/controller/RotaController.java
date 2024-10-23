package br.com.fiap.coleta.controller;

import br.com.fiap.coleta.dto.RotaCadastroDto;
import br.com.fiap.coleta.model.Rota;
import br.com.fiap.coleta.service.RotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RotaController {

    @Autowired
    private RotaService rotaService;


    @PostMapping("/rota")
    @ResponseStatus(HttpStatus.CREATED)
    public Rota gravar(@RequestBody @Valid RotaCadastroDto rotaCadastroDto) {
        return rotaService.gravar(rotaCadastroDto);
    }

    @PutMapping("/rota")
    @ResponseStatus(HttpStatus.OK)
    public Rota atualizar(@RequestBody @Valid Rota rota) {
        return rotaService.atualizar(rota);
    }

    @GetMapping("/rota")
    @ResponseStatus(HttpStatus.OK)
    public List<Rota> listarTodasAsRotas() {
        return rotaService.listarTodosAsRotas();
    }

    @GetMapping("/rota/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Rota> getRotaPorId(@PathVariable Long id){
        return rotaService.findById(id);
    }

    @DeleteMapping("/rota/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        rotaService.excluir(id);
    }

}
