package br.com.fiap.coleta.dto;

import java.time.LocalDateTime;

public record ErrorDto(
    LocalDateTime timestamp,
    Integer status,
    String error,
    String message,
    String path
) {
}
