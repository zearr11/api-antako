package com.anime.antako.enums.specials;

public enum Season {
    PRIMAVERA("Primavera"),
    INVIERNO("Invierno"),
    OTONO("Otoño"),
    VERANO("Verano"),
    NO_DEFINIDO("No definido");

    private final String value;

    Season(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}