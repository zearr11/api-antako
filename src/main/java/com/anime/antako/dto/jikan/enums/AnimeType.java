package com.anime.antako.dto.jikan.enums;

public enum AnimeType {
    TV("tv"),
    MOVIE("movie"),
    OVA("ova"),
    SPECIAL("special"),
    ONA("ona"),
    MUSIC("music"),
    CM("cm"),
    PV("pv"),
    TV_SPECIAL("tv_special");

    private final String value;

    AnimeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
