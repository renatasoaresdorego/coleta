package br.com.fiap.coleta.controller;

import br.com.fiap.coleta.dto.CaminhaoCadastroDto;
import br.com.fiap.coleta.model.Caminhao;
import br.com.fiap.coleta.model.Rota;
import br.com.fiap.coleta.service.CaminhaoService;
import br.com.fiap.coleta.service.RotaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CaminhaoController {

    @Autowired
    private CaminhaoService caminhaoService;
    private RotaService rotaService;

//    @PostMapping("/caminhao")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Caminhao gravar(@RequestBody @Valid CaminhaoCadastroDto caminhaoCadastroDto) {
//        return caminhaoService.gravar(caminhaoCadastroDto);
//    }

    @PostMapping("/caminhao")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Caminhao> cadastrarCaminhao(@Valid @RequestBody CaminhaoCadastroDto dto) {
        // Busca a rota pelo ID
        Rota rota = rotaService.findById(dto.idRota())
                .orElseThrow(() -> new EntityNotFoundException("Rota não encontrada"));

        // Cria e popula a entidade Caminhao
        Caminhao caminhao = new Caminhao();
        caminhao.setCapacidade(dto.capacidade());
        caminhao.setLocalizacaoEmTempoReal(dto.localizacaoEmTempoReal());
        caminhao.setPlaca(dto.placa());
        caminhao.setStatusServico(dto.statusServico());
        caminhao.setRota(rota); // Atribua a instância da rota aqui

        // Salva o caminhão
        Caminhao savedCaminhao = caminhaoService.gravar(caminhao); // Aqui, use o objeto caminhao
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCaminhao);
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
