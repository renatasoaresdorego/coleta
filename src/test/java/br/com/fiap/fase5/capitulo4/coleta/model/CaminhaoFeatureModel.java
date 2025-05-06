package br.com.fiap.fase5.capitulo4.coleta.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class CaminhaoFeatureModel {
    @Expose
    private String id;
    @Expose
    private String rota;
    @Expose
    private Long capacidade;
    @Expose
    private String placa;
    @Expose
    private Boolean statusServico;
}