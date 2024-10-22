package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record AgendaCadastroDto(
        Long idAgenda,

        @NotBlank (message = "A rota é obrigatória.")
        Long idRota,

//        @NotBlank (message = "O ponto é obrigatório.")
//        Long idPonto,

        @NotBlank (message = "A data da próxima coleta é obrgatória.")
        LocalDate dataProximaColeta
) {
}
