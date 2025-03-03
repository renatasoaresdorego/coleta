package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.PontoDeColetaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import br.com.fiap.fase5.capitulo4.coleta.repository.PontoDeColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PontoDeColetaService {

    @Autowired
    private PontoDeColetaRepository repository;

    @Autowired
    private PontoDeColetaMapper mapper;

    public void cadastrarPontoDeColeta(PontoDeColetaDto dto) {
        try {
            PontoDeColeta pontoDeColeta = mapper.dtoToPontoDeColeta(dto);
            pontoDeColeta.setCapacidadeAtual(definirCapacidadeAtual(dto.capacidadeMaxima()));
            repository.save(pontoDeColeta);
        } catch(DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao cadastrar novo ponto de coleta. O ponto de coleta já existe.");
        }
    }

    public List<PontoDeColetaDto> listar() {
        List<PontoDeColeta> pontosDeColeta = repository.findAll();
        return mapper.listPontoDeColetaToListDto(pontosDeColeta);
    }

    public void excluir(String id) {
        try {
            repository.deleteById(id);
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Ponto de coleta inexistente.");
        }
    }

    public Double definirCapacidadeAtual(Double capacidadeMaxima) {
        return new Random().nextDouble(0, capacidadeMaxima);
    }

}
