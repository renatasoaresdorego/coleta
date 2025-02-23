package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.CaminhaoMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Caminhao;
import br.com.fiap.fase5.capitulo4.coleta.repository.CaminhaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository repository;

    @Autowired
    private CaminhaoMapper caminhaoMapper;

    public void cadastrar(CaminhaoDto dto) {
        Caminhao caminhao = new Caminhao();
        BeanUtils.copyProperties(dto, caminhao);
        repository.save(caminhao);
    }

    public void atualizar(CaminhaoDto dto) {
        buscar(dto.idCaminhao());
        cadastrar(dto);
    }

    public List<CaminhaoDto> listar() {
        List<Caminhao> caminhoes = repository.findAll();
        List<CaminhaoDto> caminhoesDto = new ArrayList<>();
        BeanUtils.copyProperties(caminhoes, caminhoesDto);
        return caminhoesDto;
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public CaminhaoDto buscar(Long id) {
        Caminhao caminhao =  repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Caminhão não encontrado"));
        return caminhaoMapper.caminhaoToCaminhaoDto(caminhao);
    }

}
