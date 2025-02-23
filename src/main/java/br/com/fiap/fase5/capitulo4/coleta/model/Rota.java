package br.com.fiap.fase5.capitulo4.coleta.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("T_REC_ROTA")
public class Rota {

    @Id
    private Long id;

    private String nome;

    private String inicio;

    private String fim;

    private List<Caminhao> caminhoes;

    private List<Agenda> agendas;
}
