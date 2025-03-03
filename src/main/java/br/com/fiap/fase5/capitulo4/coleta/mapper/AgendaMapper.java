package br.com.fiap.fase5.capitulo4.coleta.mapper;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Agenda;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendaMapper {

    Agenda dtoToAgenda(AgendaDto dto);
    AgendaDto agendaToDto(Agenda agenda);
    List<AgendaDto> agendasToAgendasDto(List<Agenda> agendas);
}
