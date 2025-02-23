package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.RotaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Rota;
import br.com.fiap.fase5.capitulo4.coleta.repository.RotaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    @Autowired
    private RotaRepository repository;

    public Rota gravar(RotaDto dto){
        Rota rota = new Rota();
        BeanUtils.copyProperties(dto, rota);
        return repository.save(rota);
    }

    public void atualizar(RotaDto dto) {
        buscar(dto.id());
        gravar(dto);
    }

    public List<Rota> listar(){
        return repository.findAll();
    }

    public void excluir(Long id){
        repository.delete(buscar(id));
    }

    public Rota buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("A rota informada não está cadastrada."));
    }

}
