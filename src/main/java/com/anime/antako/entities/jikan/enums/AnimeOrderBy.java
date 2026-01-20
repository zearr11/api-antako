package com.anime.antako.entities.jikan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
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
}
