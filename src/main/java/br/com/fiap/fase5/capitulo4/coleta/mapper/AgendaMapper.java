package br.com.fiap.fase5.capitulo4.coleta.mapper;

import br.com.fiap.fase5.capitulo4.coleta.dto.AgendaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Agenda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendaMapper {
    AgendaMapper INSTANCE = Mappers.getMapper(AgendaMapper.class);

    @Mapping(target = "rota", ignore = true)
    @Mapping(target = "pontoDeColeta", ignore = true)
    Agenda dtoToAgenda(AgendaDto dto);

    @Mapping(target = "rota", ignore = true)
    @Mapping(target = "pontoDeColeta", ignore = true)
    AgendaDto agendaToDto(Agenda agenda);

    @Mapping(target = "rota", ignore = true)
    @Mapping(target = "pontoDeColeta", ignore = true)
    List<AgendaDto> agendasToAgendasDto(List<Agenda> agendas);
}
