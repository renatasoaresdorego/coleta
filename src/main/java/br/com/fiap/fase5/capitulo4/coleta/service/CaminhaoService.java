package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.CaminhaoMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Caminhao;
import br.com.fiap.fase5.capitulo4.coleta.repository.CaminhaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository repository;

    @Autowired
    private CaminhaoMapper mapper;

    public void cadastrar(CaminhaoDto dto) {
        try {
            repository.save(mapper.caminhaoDtoToCaminhao(dto));
        } catch(DataIntegrityViolationException e) {
            throw new RuntimeException("Erro. Caminhão já cadastrado.");
        }
    }

    public void atualizar(CaminhaoDto dto) {
        Caminhao caminhao = repository.findById(dto.idCaminhao())
                .orElseThrow(() -> new RuntimeException("Caminhão não encontrado."));
        caminhao = mapper.caminhaoDtoToCaminhao(dto);
        repository.save(caminhao);
    }

    public CaminhaoDto buscar(String id) {
        Caminhao caminhao =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caminhão não encontrado"));
        return mapper.caminhaoToCaminhaoDto(caminhao);
    }

    public List<CaminhaoDto> listar() {
        List<Caminhao> caminhoes = repository.findAll();
        List<CaminhaoDto> caminhoesDto = new ArrayList<>();
        for(Caminhao caminhao : caminhoes) {
           caminhoesDto.add(mapper.caminhaoToCaminhaoDto(caminhao));
        }
        return caminhoesDto;
    }

    public void excluir(String id) {
        try {
            repository.deleteById(id);
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Caminhão não encontrado.");
        }
    }

}
