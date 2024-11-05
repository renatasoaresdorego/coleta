package br.com.fiap.coleta.dto;

import br.com.fiap.coleta.model.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioCadastroDto(

        Long usuarioId,

        @NotBlank(message = "O campo 'nome' é obrigatório.")
        String nome,

        @NotBlank(message = "O campo 'cpf' é obrigatório")
        @Pattern( regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}|\\d{11})$", message = "CPF inválido" )
        String cpf,

        @NotBlank(message = "O campo 'número de telefone' é obrigatório")
        @Pattern(
                regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}",
                message = "Número de telefone inválido")
        String telefone,

        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,12}$",
                message = "A senha não corresponde ao padrão especifícado."
                        + "Combine letras maíusculas e minúsculas, números e caracteres especiais.")
        String senha,

        Role role

) {
}
