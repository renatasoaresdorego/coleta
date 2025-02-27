package br.com.fiap.fase5.capitulo4.coleta.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "pontosDeColeta")
public class PontoDeColeta {

    @Id
    private Long id;

    private String endereco;

    private Double capacidadeMaxima;

    private Double capacidadeAtual;

    private Residuo residuo;

    @DBRef
    private List<Agenda> agendamentosDeColeta;

}
