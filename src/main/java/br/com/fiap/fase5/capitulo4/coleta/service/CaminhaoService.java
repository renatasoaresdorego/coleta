package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.CaminhaoMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Caminhao;
import br.com.fiap.fase5.capitulo4.coleta.repository.CaminhaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository repository;

    public void cadastrar(CaminhaoDto dto) {
        try {
            repository.save(CaminhaoMapper.INSTANCE.caminhaoDtoToCaminhao(dto));
            log.info("Caminhão cadastrado com sucesso.");
        } catch(DataIntegrityViolationException e) {
            throw new RuntimeException("Erro. Caminhão já cadastrado.");
        }
    }

    public void atualizar(CaminhaoDto dto) {
        Caminhao caminhao = repository.findById(dto.idCaminhao())
                .orElseThrow(() -> new RuntimeException("Caminhão não encontrado."));
        caminhao = CaminhaoMapper.INSTANCE.caminhaoDtoToCaminhao(dto);
        repository.save(caminhao);
        log.info("Caminhão atualizado com sucesso.");
    }

    public CaminhaoDto buscar(String id) {
        Caminhao caminhao =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caminhão não encontrado"));
        return CaminhaoMapper.INSTANCE.caminhaoToCaminhaoDto(caminhao);
    }

    public List<CaminhaoDto> listar() {
        List<Caminhao> caminhoes = repository.findAll();
        List<CaminhaoDto> caminhoesDto = new ArrayList<>();
        for(Caminhao caminhao : caminhoes) {
           caminhoesDto.add(CaminhaoMapper.INSTANCE.caminhaoToCaminhaoDto(caminhao));
        }
        return caminhoesDto;
    }

    public void excluir(String id) {
        try {
            repository.deleteById(id);
            log.info("Caminhao excluído com sucesso.");
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Caminhão não encontrado.");
        }
    }

}

