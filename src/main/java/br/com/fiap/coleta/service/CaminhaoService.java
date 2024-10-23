package br.com.fiap.coleta.service;

import br.com.fiap.coleta.dto.CaminhaoCadastroDto;
import br.com.fiap.coleta.model.Caminhao;
import br.com.fiap.coleta.model.Rota;
import br.com.fiap.coleta.repository.CaminhaoRepository;
import br.com.fiap.coleta.repository.RotaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaminhaoService {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private RotaService rotaService;


    public Caminhao gravar(@Valid CaminhaoCadastroDto caminhaoCadastroDto) {
        Caminhao caminhao = new Caminhao();
        Optional<Rota> optionalRota = rotaService.findById(caminhaoCadastroDto.idRota());

        Rota rota = optionalRota.orElseThrow(() ->
                new RuntimeException("Rota não encontrada para o ID: " + caminhaoCadastroDto.idRota())
        );

        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao);
        caminhao.setRota(rota);

        System.out.println("Rota encontrada, salvando caminhão.");
        return caminhaoRepository.save(caminhao);
    }


    public Caminhao atualizar(CaminhaoCadastroDto caminhaoCadastroDto) {
        Long idCaminhao = caminhaoCadastroDto.idCaminhao();
        Optional<Caminhao> optionalCaminhao = caminhaoRepository.findById(idCaminhao);
        Caminhao caminhao = optionalCaminhao.get();

        BeanUtils.copyProperties(caminhaoCadastroDto, caminhao, "idCaminhao"); // ignora o idCaminha na hora de copiar

        return caminhaoRepository.save(caminhao);
    }

    public void excluir(Long idCaminhao) {
        Optional<Caminhao> caminhaoOptional = caminhaoRepository.findById(idCaminhao);

        if (caminhaoOptional.isPresent()) {
            caminhaoRepository.delete(caminhaoOptional.get());
        } else throw new RuntimeException("Caminhão não encontrado");
    }

    public Optional<Caminhao> findById(@NotNull(message = "O id do caminhão é obrigatório.") @Min(1) Long id) {
        return caminhaoRepository.findById(id);
    }

    public List<Caminhao> listarTodosOsCaminhoes() {
        return caminhaoRepository.findAll();
    }
}
