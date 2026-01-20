package com.anime.antako.dto.jikan.enums;

public enum AnimeOrderBy {

    MAL_ID("mal_id"),
    TITLE("title"),
    START_DATE("start_date"),
    END_DATE("end_date"),
    EPISODES("episodes"),
    SCORE("score"),
    SCORED_BY("scored_by"),
    RANK("rank"),
    POPULARITY("popularity"),
    MEMBERS("members");

    private final String value;

    AnimeOrderBy(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
