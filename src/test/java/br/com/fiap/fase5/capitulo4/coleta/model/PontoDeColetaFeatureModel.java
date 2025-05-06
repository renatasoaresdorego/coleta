package br.com.fiap.fase5.capitulo4.coleta.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PontoDeColetaFeatureModel {
    @Expose
    private String id;
    @Expose
    private String endereco;
    @Expose
    private BigDecimal capacidadeMaxima;
    @Expose
    private BigDecimal capacidadeAtual;
    @Expose
    private String residuo;
}