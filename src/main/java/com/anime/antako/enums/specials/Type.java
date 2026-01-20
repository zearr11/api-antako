package com.anime.antako.enums.specials;

public enum Type {
    TV_ANIME("TV Anime"),
    PELICULA("Película"),
    OVA("OVA"),
    ESPECIAL("Especial"),
    ONA("Animación Original"),

    MUSICA("Música"),
    COMERCIAL("Comercial"),
    VIDEO_PROMOCIONAL("Video Promocional"),

    TV_ESPECIAL("TV Especial");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
