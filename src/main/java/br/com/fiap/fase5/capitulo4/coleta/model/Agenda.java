package br.com.fiap.fase5.capitulo4.coleta.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("T_REC_AGENDA")
public class Agenda {

    @Id
    private Long id;

    private LocalDate dataProximaColeta;

    private LocalDate dataUltimaColeta;

    private Rota rota;

    private PontoDeColeta pontoDeColeta;
}
