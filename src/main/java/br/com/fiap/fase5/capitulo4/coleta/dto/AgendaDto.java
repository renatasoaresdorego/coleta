package br.com.fiap.fase5.capitulo4.coleta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AgendaDto(
        String id,

        LocalDateTime dataProximaColeta,

        LocalDateTime dataUltimaColeta,

        @NotNull(message = "A rota é obrigatória.")
        @NotBlank(message = "A rota não pode estar em branco.")
        String rota,

        @NotNull(message = "O ponto de coleta é obrigatório.")
        @NotBlank(message = "O ponto de coleta não pode estar em branco.")
        String pontoDeColeta
){

}
