package br.com.fiap.fase5.capitulo4.coleta.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgendaFeatureModel {
    @Expose
    private LocalDateTime dataProximaColeta;
    @Expose
    private String rota;
    @Expose
    private String pontoDeColeta;
}