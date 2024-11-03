package br.com.fiap.coleta.model;

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
