package br.com.fiap.fase5.capitulo4.coleta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Residuo {
    ORGANICO("Orgânico"),
    PAPEL("Papel"),
    VIDRO("Vidro"),
    METAL("Metal"),
    PLASTICO("Plástico"),
    COMUM("Comum"),
    INFECTANTE("Infectante"),
    ELETRONICO("Eletrônico");

    private final String residuo;

}
