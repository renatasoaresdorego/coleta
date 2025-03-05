package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
import br.com.fiap.fase5.capitulo4.coleta.dto.RotaDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.AgendaMapper;
import br.com.fiap.fase5.capitulo4.coleta.mapper.PontoDeColetaMapper;
import br.com.fiap.fase5.capitulo4.coleta.mapper.RotaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Agenda;
import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import br.com.fiap.fase5.capitulo4.coleta.model.Rota;
import br.com.fiap.fase5.capitulo4.coleta.repository.AgendaRepository;
import br.com.fiap.fase5.capitulo4.coleta.repository.PontoDeColetaRepository;
import br.com.fiap.fase5.capitulo4.coleta.repository.RotaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class AgendaService {

    @Autowired
    private AgendaRepository repository;

    @Autowired
    private RotaService rotaService;

    @Autowired
    private PontoDeColetaService pontoDeColetaService;

    public void agendar(AgendaDto dto) {
        try {
            Agenda agenda = new Agenda();
            agenda.setRota(RotaMapper.INSTANCE.dtoToRota(rotaService.buscar(dto.rota())));
            agenda.setPontoDeColeta(PontoDeColetaMapper.INSTANCE.exibicaoDtoToPontoDeColeta(
                    pontoDeColetaService.buscar(dto.pontoDeColeta())));
            agenda.setDataUltimaColeta(LocalDateTime.now());
            repository.save(agenda);
            log.info("Coleta agendada com sucesso.");
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Ocorreu um erro ao agendar a coleta. Verifique os dados informados.");
        }
    }

    public List<AgendaDto> agendamentos() {
        List<Agenda> agendas = repository.findAll();
        return AgendaMapper.INSTANCE.agendasToAgendasDto(agendas);
    }

    public void concluir(String id) {
        try {
            Agenda agenda = repository.findById(id).orElseThrow(() -> new RuntimeException("Agenda não encontrada."));
            agenda.setDataUltimaColeta(LocalDateTime.now());
            repository.save(agenda);
            log.info("Coleta concluída com sucesso.");
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("A agenda é inválida. Não foi possível concluir a coleta.");
        }
    }

    public void suspender(String id) {
        Agenda agenda = repository.findById(id).orElseThrow(() -> new RuntimeException("Agenda não encontrada."));
        agenda.setDataProximaColeta(LocalDateTime.MIN);
        repository.save(agenda);
        log.info("Coleta suspensa com sucesso.");
    }

}
