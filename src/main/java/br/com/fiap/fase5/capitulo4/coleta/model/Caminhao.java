package br.com.fiap.fase5.capitulo4.coleta.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "caminhoes")
public class Caminhao {

    @Id
    private Long id;

    private Long capacidade;

    private String localizacaoEmTempoReal;

    private String placa;

    private Boolean statusServico;

    @DBRef
    private Rota rota;
}
