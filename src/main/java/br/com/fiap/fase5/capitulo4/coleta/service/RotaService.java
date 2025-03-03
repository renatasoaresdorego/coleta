package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.RotaDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.RotaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Rota;
import br.com.fiap.fase5.capitulo4.coleta.repository.RotaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    @Autowired
    private RotaRepository repository;

    @Autowired
    private RotaMapper mapper;

    public Rota gravar(RotaDto dto){
        try {
            return repository.save(mapper.dtoToRota(dto));
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("A rota informada já está cadastrada.");
        }
    }

    public void atualizar(RotaDto dto) {
       Rota rota = repository.findById(dto.id()).orElseThrow(() ->  new RuntimeException("Rota não encontrada."));
       repository.save(mapper.dtoToRota(dto));
    }

    public List<RotaDto> listar(){
        List<Rota> rotas = repository.findAll();
        return mapper.rotasToRotasDto(rotas);
    }

    public void excluir(String id){
        try {
            repository.deleteById(id);
        } catch(IllegalArgumentException e) {
            throw new RuntimeException("Rota não encontrada.");
        }
    }

    public RotaDto buscar(String id) {
        return mapper.rotaToDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("A rota informada não está cadastrada.")));
    }

}
