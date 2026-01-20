package com.anime.antako.enums;

public enum EmisionDay {

    LUNES("Lunes"),
    MARTES("Martes"),
    MIERCOLES("Miércoles"),
    JUEVES("Jueves"),
    VIERNES("Viernes"),
    SABADO("Sábado"),
    DOMINGO("Domingo"),
    NO_DEFINIDO("no definido");

    private final String value;

    EmisionDay(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
