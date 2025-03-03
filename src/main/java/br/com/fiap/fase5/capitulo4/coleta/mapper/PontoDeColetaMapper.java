package br.com.fiap.fase5.capitulo4.coleta.mapper;

import br.com.fiap.fase5.capitulo4.coleta.dto.PontoDeColetaDto;
import br.com.fiap.fase5.capitulo4.coleta.model.PontoDeColeta;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PontoDeColetaMapper {

    PontoDeColeta dtoToPontoDeColeta(PontoDeColetaDto dto);
    List<PontoDeColetaDto> listPontoDeColetaToListDto(List<PontoDeColeta> pontosDeColeta);
}
