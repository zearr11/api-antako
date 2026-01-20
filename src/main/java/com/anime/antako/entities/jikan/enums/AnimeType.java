package com.anime.antako.entities.jikan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
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
}
