package br.com.fiap.fase5.capitulo4.coleta.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "agendas")
public class Agenda {

    @Id
    private String id;

    private LocalDate dataProximaColeta;

    private LocalDate dataUltimaColeta;

    @DBRef
    private Rota rota;

    @DBRef
    private PontoDeColeta pontoDeColeta;

}
