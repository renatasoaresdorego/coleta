package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
import br.com.fiap.fase5.capitulo4.coleta.mapper.AgendaMapper;
import br.com.fiap.fase5.capitulo4.coleta.model.Agenda;
import br.com.fiap.fase5.capitulo4.coleta.repository.AgendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository repository;

    @Autowired
    private AgendaMapper mapper;

    public void agendarColeta(AgendaDto dto) {
        try {
            repository.save(mapper.dtoToAgenda(dto));
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Ocorreu um erro ao agendar a coleta. Verifique os dados informados.");
        }
    }

    public void concluirColeta(AgendaDto dto) {
        try {
            Agenda agenda = mapper.dtoToAgenda(dto);
            agenda.setDataUltimaColeta(LocalDate.now());
            repository.save(agenda);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("A agenda é inválida. Não foi possível concluir a coleta.");
        }
    }

    public void suspenderColeta(String id) {
        Agenda agenda = repository.findById(id).orElseThrow(() -> new RuntimeException("Agenda não encontrada."));
        agenda.setDataProximaColeta(LocalDate.EPOCH);
        repository.save(agenda);
    }

    public List<AgendaDto> agendamentos() {
        List<Agenda> agendas = repository.findAll();
        return mapper.agendasToAgendasDto(agendas);
    }

}
