package com.anime.antako.dto.jikan.enums;

public enum AnimeStatus {

    AIRING("airing"),
    COMPLETE("complete"),
    UPCOMING("upcoming");

    private final String value;

    AnimeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
