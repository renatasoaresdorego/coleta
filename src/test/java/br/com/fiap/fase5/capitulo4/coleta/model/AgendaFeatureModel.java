package br.com.fiap.fase5.capitulo4.coleta.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendaFeatureModel {
    @Expose
    private String id;
    @Expose
    private LocalDateTime dataProximaColeta;
    @Expose
    private LocalDateTime dataUltimaColeta;
    @Expose
    private String rota;
    @Expose
    private String pontoDeColeta;
}