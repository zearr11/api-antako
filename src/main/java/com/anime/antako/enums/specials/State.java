package com.anime.antako.enums.specials;

public enum State {
    FINALIZADO("Finalizado"),
    PROXIMAMENTE("Próximamente"),
    EN_EMISION("En emisión");

    private final String value;

    State(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
