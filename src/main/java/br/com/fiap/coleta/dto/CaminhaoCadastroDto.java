package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.NotBlank;

public record CaminhaoCadastroDto(

        Long idCaminhao,

        @NotBlank(message = "O id da rota é obrigatório.")
        Long idRota,

        @NotBlank(message = "A capacidade é obrigatória.")
        Long capacidade,

        @NotBlank(message = "Placa é obrigatória.")
        String placa,

        @NotBlank(message = "O status do serviço é obrigatório.")
        Boolean statusServico
) {
}
