package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaCadastroDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaExibicaoDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.PontoDeColetaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import br.com.fiap.fase5.capitulo4.coleta.repository.PontoDeColetaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class PontoDeColetaService {

    @Autowired
    private PontoDeColetaRepository repository;

    @Autowired
    private PontoDeColetaMapper mapper;

    public void cadastrar(PontoDeColetaCadastroDto dto) {
        try {
            PontoDeColeta pontoDeColeta = mapper.cadastroDtoToPontoDeColeta(dto);
            pontoDeColeta.setCapacidadeAtual(definirCapacidadeAtual(dto.capacidadeMaxima()));
            repository.save(pontoDeColeta);
            log.info("Ponto de coleta salvo com sucesso.");
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao cadastrar novo ponto de coleta. O ponto de coleta já existe.");
        }
    }

    public List<PontoDeColetaExibicaoDto> listar() {
        List<PontoDeColeta> pontosDeColeta = repository.findAll();
        return mapper.listaExibicaoDtoToListaPontoDeColeta(pontosDeColeta);
    }

    public void atualizar(PontoDeColetaCadastroDto dto) {
        repository.findById(dto.id()).orElseThrow(() -> new RuntimeException("Ponto de coleta não encontrado."));
        repository.save(mapper.cadastroDtoToPontoDeColeta(dto));
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
