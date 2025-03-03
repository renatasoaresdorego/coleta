package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.RotaDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.RotaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Rota;
import br.com.fiap.fase5.capitulo4.coleta.repository.RotaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RotaService {

    @Autowired
    private RotaRepository repository;

    @Autowired
    private RotaMapper mapper;

    public RotaDto gravar(RotaDto dto){
        try {
            Rota rota = mapper.dtoToRota(dto);
            repository.save(rota);
            log.info("Rota gravada com sucesso.");
            return mapper.rotaToDto(rota);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("A rota informada já está cadastrada.");
        }
    }

    public RotaDto buscar(String id) {
        return mapper.rotaToDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("A rota informada não está cadastrada.")));
    }

    public void atualizar(RotaDto dto) {
       repository.findById(dto.id()).orElseThrow(() ->  new RuntimeException("Rota não encontrada."));
       repository.save(mapper.dtoToRota(dto));
       log.info("Rota atualizada com sucesso.");
    }

    public List<RotaDto> listar(){
        List<Rota> rotas = repository.findAll();
        log.info("Rotas listadas com sucesso.");
        return mapper.rotasToRotasDto(rotas);
    }

    public void excluir(String id){
        try {
            repository.deleteById(id);
            log.info("Rota excluída com sucesso.");
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Rota não encontrada.");
        }
    }

}
