package com.anime.antako.entities.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {
    FINALIZADO("Finalizado"),
    PROXIMAMENTE("Próximamente"),
    EN_EMISION("En emisión");

    private final String value;
}
