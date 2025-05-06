package br.com.fiap.fase5.capitulo4.coleta.model;

import com.google.gson.annotations.Expose;
import lombok.Data;

@Data
public class RotaFeatureModel {
    @Expose
    private String id;
    @Expose
    private String nome;
    @Expose
    private String inicio;
    @Expose
    private String fim;
}