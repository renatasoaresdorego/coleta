package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.PontoDeColetaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import br.com.fiap.fase5.capitulo4.coleta.repository.PontoDeColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
        PontoDeColeta pontoDeColeta = new PontoDeColeta();
        pontoDeColeta.setCapacidadeAtual(definirCapacidadeAtual(dto.capacidadeMaxima()));
        BeanUtils.copyProperties(dto, pontoDeColeta);
        repository.save(pontoDeColeta);
    }

    public List<PontoDeColetaDto> listar() {
        List<PontoDeColeta> pontosDeColeta = repository.findAll();
        return mapper.listPontoDeColetaToListDto(pontosDeColeta);
    }

    public void excluir(String id) {
        repository.deleteById(id);
    }

    public Double definirCapacidadeAtual(Double capacidadeMaxima) {
        return new Random().nextDouble(0, capacidadeMaxima);
    }

}
