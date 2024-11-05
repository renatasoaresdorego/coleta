package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.NotBlank;

public record RotaCadastroDto(

        @NotBlank(message = "O nome da rota é obrigatório.")
        String nome,

        @NotBlank(message = "O local onde a rota se inicia é obrigatório.")
        String inicio,

        @NotBlank(message = "O local onde a rota termina é obrigatório.")
        String fim
) {
}
