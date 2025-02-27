package br.com.fiap.fase5.capitulo4.coleta.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "rotas")
public class Rota {

    @Id
    private Long id;

    private String nome;

    private String inicio;

    private String fim;

    @DBRef
    private List<Caminhao> caminhoes;

    @DBRef
    private List<Agenda> agendas;
}
