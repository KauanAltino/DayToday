package br.com.fiap.daytoday.models;

public record RestValidationError(
    Integer code,
    String field,
    String message
) {}
