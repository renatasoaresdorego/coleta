package br.com.fiap.fase5.capitulo4.coleta.mapper;

import br.com.fiap.fase5.capitulo4.coleta.dto.RotaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Rota;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RotaMapper {

    Rota dtoToRota(RotaDto dto);
    RotaDto rotaToDto(Rota rota);
    List<RotaDto> rotasToRotasDto(List<Rota> rotas);
}
