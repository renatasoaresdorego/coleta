package br.com.fiap.fase5.capitulo4.coleta.service;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Agenda;
import br.com.fiap.fase5.capitulo4.coleta.repository.AgendaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository repository;

    public void agendarColeta(AgendaDto dto) {
        Agenda agenda = mapear(dto);
        repository.save(agenda);
    }

    public void concluirColeta(AgendaDto dto) {
        Agenda agenda = mapear(dto);
        agenda.setDataUltimaColeta(LocalDate.now());
        repository.save(agenda);
    }

    public void suspenderColeta(Long id) {
        Agenda agenda = buscar(id);
        agenda.setDataProximaColeta(LocalDate.EPOCH);
        repository.save(agenda);
    }

    public List<AgendaDto> agendamentos() {
        List<AgendaDto> agendaDtos = new ArrayList<>();
        List<Agenda> agendamentos = new ArrayList<>();
        BeanUtils.copyProperties(agendamentos, agendaDtos);
        return agendaDtos;
    }

    public Agenda buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agenda não encontrada. Indisponível."));
    }

    public Agenda mapear(AgendaDto dto) {
        buscar(dto.idAgenda());
        Agenda agenda = new Agenda();
        BeanUtils.copyProperties(dto, agenda);
        return agenda;
    }

}
