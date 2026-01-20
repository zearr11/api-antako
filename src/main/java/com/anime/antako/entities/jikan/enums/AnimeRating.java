package com.anime.antako.entities.jikan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimeRating {
    G("g", "All Ages"),
    PG("pg", "Children"),
    PG13("pg13", "Teens 13 or older"),
    R17("r17", "17+ (violence & profanity)"),
    R("r", "Mild Nudity"),
    RX("rx", "Hentai");

    private final String value;
    private final String description;
}
