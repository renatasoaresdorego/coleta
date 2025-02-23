package br.com.fiap.fase5.capitulo4.coleta.dto;

import jakarta.validation.constraints.NotBlank;

public record CaminhaoDto(

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
