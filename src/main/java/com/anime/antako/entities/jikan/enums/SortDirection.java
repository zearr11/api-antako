package com.anime.antako.entities.jikan.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SortDirection {
    ASC("asc"),
    DESC("desc");

    private final String value;
}
