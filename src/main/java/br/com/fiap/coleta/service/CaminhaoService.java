package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.CaminhaoCadastroDto;
import br.com.fiap.coleta.model.Caminhao;
import br.com.fiap.coleta.repository.CaminhaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    public Caminhao gravar(CaminhaoCadastroDto caminhaoCadastroDto){
        Caminhao caminhao = new Caminhao();
        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao);
        return caminhaoRepository.save(caminhao);
    }

    public Caminhao atualizar(Caminhao caminhao){
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(caminhao.getIdCaminhao());

        if(caminhaoOptional.isPresent()){
            return caminhaoRepository.save(caminhao);
        } else throw new RuntimeException("Caminhão não encontrado.");
    }

    public List<Caminhao> listarTodosOsCaminhoes(){
        return caminhaoRepository.findAll();
    }

    public void excluir(Long idCaminhao){
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(idCaminhao);

        if(caminhaoOptional.isPresent()){
            caminhaoRepository.delete(caminhaoOptional.get());
        } else throw new RuntimeException("Caminhão não encontrado");
    }
}
