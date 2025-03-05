package br.com.fiap.fase5.capitulo4.coleta.mapper;

import br.com.fiap.fase5.capitulo4.coleta.dto.CaminhaoDto;
import br.com.fiap.fase5.capitulo4.coleta.model.Caminhao;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CaminhaoMapper {
    CaminhaoMapper INSTANCE = Mappers.getMapper(CaminhaoMapper.class);

    Caminhao caminhaoDtoToCaminhao(CaminhaoDto caminhaoDto);
    CaminhaoDto caminhaoToCaminhaoDto(Caminhao caminhao);
}
