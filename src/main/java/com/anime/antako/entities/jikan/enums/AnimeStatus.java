package com.anime.antako.entities.jikan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimeStatus {
    AIRING("airing"),
    COMPLETE("complete"),
    UPCOMING("upcoming");

    private final String value;
}
