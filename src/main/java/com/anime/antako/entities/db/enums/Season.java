package com.anime.antako.entities.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Season {
    PRIMAVERA("Primavera"),
    INVIERNO("Invierno"),
    OTONO("Otoño"),
    VERANO("Verano"),
    NO_DEFINIDO("No definido");

    private final String value;
}