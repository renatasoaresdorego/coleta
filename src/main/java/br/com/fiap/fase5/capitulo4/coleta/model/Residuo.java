package br.com.fiap.fase5.capitulo4.coleta.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Residuo {
    ORGANICO("Orgânico"),
    COMUN("Comun"),
    RECICLAVEL("Reciclável");

    private final String residuo;

}
