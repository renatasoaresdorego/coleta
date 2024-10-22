package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MoradorCadastroDto(
        Long idMorador,

        @NotBlank(message = "O id da agenda é obrigatório.")
        Long idAgenda,

        @NotBlank(message = "O nome do morador é obrigatório.")
        String nome,

        @NotBlank(message = "O telefone é obrigatório.")
        String telefone,

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "O formato do email é inválido.")
        String email
) {
}
