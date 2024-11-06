package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.Role;
import jakarta.validation.constraints.*;

public record UsuarioCadastroDto(

        Long usuarioId,

        @NotBlank(message = "O campo 'cpf' é obrigatório")
        @Pattern( regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}|\\d{11})$", message = "CPF inválido" )
        String cpf,

        @NotBlank(message = "O nome do morador é obrigatório.")
        String nome,

        @Size(min = 10, max = 11, message = "Informe o telefone com o DDD.")
        @NotBlank(message = "O telefone é obrigatório.")
        String telefone,

        @NotBlank(message = "O email é obrigatório.")
        @Email(message = "O formato do email é inválido.")
        String email,

        @Size(min = 6, max = 8, message = "A senha deve conter entre 6 e 8 dígitos" )
        @NotBlank(message = "A senha é obrigatória.")
        String senha,

        Role role

) {
}
