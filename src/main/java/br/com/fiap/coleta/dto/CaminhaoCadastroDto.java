package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.Rota;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CaminhaoCadastroDto(

        Long idCaminhao,

        @NotNull(message = "O id da rota é obrigatório.")
        @Min(1)
        Long idRota,

        @NotNull (message = "A capacidade é obrigatória.")
        @Min(1)
        Long capacidade,

        @NotBlank (message = "A localização é obrigatória.")
        String localizacaoEmTempoReal,

        @NotBlank(message = "Placa é obrigatória.")
        String placa,

        @NotNull(message = "O status do serviço é obrigatório.")
        Boolean statusServico
) {

}
