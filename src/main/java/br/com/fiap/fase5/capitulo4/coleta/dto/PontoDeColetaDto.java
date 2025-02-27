package br.com.fiap.fase5.capitulo4.coleta.dto;

import br.com.fiap.fase5.capitulo4.coleta.model.Agenda;
import br.com.fiap.fase5.capitulo4.coleta.model.Residuo;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record PontoDeColetaDto(

        String id,

        @NotBlank(message = "É preciso informar o endereço do ponto de coleta")
        String endereco,

        @NotBlank(message = "É preciso informar a capacidade máxima.")
        Double capacidadeMaxima,

        Double capacidadeAtual,

        @NotBlank(message = "Escolha o tipo de resíduo coletado.")
        Residuo residuo,

        List<Agenda> agendamentos
) {
}
