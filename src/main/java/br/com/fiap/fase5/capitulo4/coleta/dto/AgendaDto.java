package br.com.fiap.fase5.capitulo4.coleta.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AgendaDto(
        Long idAgenda,

        @NotBlank (message = "A rota é obrigatória.")
        Long idRota,

        @NotBlank (message = "A data da próxima coleta é obrigatória.")
        LocalDate dataProximaColeta
){

}
