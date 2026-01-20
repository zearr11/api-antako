package com.anime.antako.dto.jikan.enums;

public enum AnimeRating {

    G("g", "All Ages"),
    PG("pg", "Children"),
    PG13("pg13", "Teens 13 or older"),
    R17("r17", "17+ (violence & profanity)"),
    R("r", "Mild Nudity"),
    RX("rx", "Hentai");

    private final String value;
    private final String description;

    AnimeRating(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
