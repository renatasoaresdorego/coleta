package br.com.fiap.fase5.capitulo4.coleta.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("T_REC_PONTO")
public class PontoDeColeta {

    @Id
    private Long id;

    private String endereco;

    private Double capacidadeMaxima;

    private Double capacidadeAtual;

    private Residuo residuo;

    private List<Agenda> agendamentosDeColeta;

}
