package com.anime.antako.dto.jikan.enums;

public enum SortDirection {

    ASC("asc"),
    DESC("desc");

    private final String value;

    SortDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
