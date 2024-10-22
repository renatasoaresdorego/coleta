package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.RotaCadastroDto;
import br.com.fiap.coleta.model.Rota;
import br.com.fiap.coleta.repository.RotaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository repo;

    public Rota gravar(RotaCadastroDto rotaCadastroDto){
        Rota rota = new Rota();
        BeanUtils.copyProperties(rotaCadastroDto, rota);
        return repo.save(rota);
    }

    public Rota atualizar(Rota rota) {
        Optional<Rota> rotaOptional = repo.findById(rota.getIdRota());

        if(rotaOptional.isPresent()){
            return repo.save(rota);
        } else throw new RuntimeException("Rota não encontrada.");
    }

    public List<Rota> listarTodosAsRotas(){
        return repo.findAll();
    }

    public void excluir(Long idRota){
        Optional<Rota> rotaOptional = repo.findById(idRota);

        if(rotaOptional.isPresent()){
            repo.delete(rotaOptional.get());
        } else throw new RuntimeException("Rota não encontrada.");
    }


}
