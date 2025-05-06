package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.PontoDeColetaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import br.com.fiap.fase5.capitulo4.coleta.repository.PontoDeColetaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class PontoDeColetaService {

    @Autowired
    private PontoDeColetaRepository repository;

    public void cadastrar(PontoDeColetaCadastroDto dto) {
        // Verifica se o ponto de coleta já existe pelo ID
        if (repository.existsById(dto.id())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ponto de coleta já cadastrado com o ID informado.");
        }


        PontoDeColeta pontoDeColeta = new PontoDeColeta();
        pontoDeColeta.setId(dto.id());
        pontoDeColeta.setEndereco(dto.endereco());
        pontoDeColeta.setCapacidadeMaxima(dto.capacidadeMaxima());
        pontoDeColeta.setCapacidadeAtual(dto.capacidadeAtual());
        pontoDeColeta.setResiduo(dto.residuo().toString());

        repository.save(pontoDeColeta);
    }

    public List<PontoDeColetaExibicaoDto> listar() {
        List<PontoDeColeta> pontosDeColeta = repository.findAll();
        return PontoDeColetaMapper.INSTANCE.listaExibicaoDtoToListaPontoDeColeta(pontosDeColeta);
    }

    public PontoDeColetaExibicaoDto buscar(String id) {
        PontoDeColeta pontoDeColeta = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ponto de coleta não encontrado."));
        return PontoDeColetaMapper.INSTANCE.pontoDeColetaToExibicaoDto(pontoDeColeta);
    }

    public void atualizar(PontoDeColetaCadastroDto dto) {
        repository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Ponto de coleta não encontrado."));
        repository.save(PontoDeColetaMapper.INSTANCE.cadastroDtoToPontoDeColeta(dto));
        log.info("Ponto de coleta atualizado com sucesso.");
    }

    public void excluir(String id) {
        try {
            repository.deleteById(id);
            log.info("Ponto de coleta excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Ponto de coleta inexistente.");
        }
    }

    public BigDecimal definirCapacidadeAtual(BigDecimal capacidadeMaxima) {
        return BigDecimal.valueOf(new Random().nextDouble(0, capacidadeMaxima.doubleValue()))
                .setScale(2, RoundingMode.HALF_UP);
    }

}
