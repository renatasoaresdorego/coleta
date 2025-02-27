package br.com.fiap.fase5.capitulo4.coleta.config;

import br.com.fiap.fase5.capitulo4.coleta.mapper.CaminhaoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CaminhaoMapper caminhaoMapper() {
        return Mappers.getMapper(CaminhaoMapper.class);
    }
}