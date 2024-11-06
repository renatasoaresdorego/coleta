package br.com.fiap.coleta.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "O campo 'cpf' é obrigatório")
        @Pattern( regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}|\\d{11})$", message = "CPF inválido" )
        String cpf,
        @Size(min = 6, max = 8, message = "A senha deve conter entre 6 e 8 dígitos" )
        @NotBlank(message = "A senha é obrigatória.")
        String senha
) {
}
