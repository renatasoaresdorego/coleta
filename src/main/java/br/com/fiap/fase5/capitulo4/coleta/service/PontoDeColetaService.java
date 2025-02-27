package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import br.com.fiap.fase5.capitulo4.coleta.repository.PontoDeColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PontoDeColetaService {

    @Autowired
    private PontoDeColetaRepository repository;

    public void cadastrarPontoDeColeta(PontoDeColetaDto dto) {
        PontoDeColeta pontoDeColeta = new PontoDeColeta();
        BeanUtils.copyProperties(dto, pontoDeColeta);
        repository.save(pontoDeColeta);
    }

    public List<PontoDeColetaDto> listar() {
        List<PontoDeColetaDto> pontosDeColetaDto = new ArrayList<>();
        List<PontoDeColeta> pontosDeColeta = new ArrayList<>();
        BeanUtils.copyProperties(pontosDeColeta, pontosDeColetaDto);
        return pontosDeColetaDto;
    }

    public void excluir(String id) {
        repository.deleteById(id);
    }

}
