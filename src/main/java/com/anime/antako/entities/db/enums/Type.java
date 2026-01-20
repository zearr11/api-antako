package com.anime.antako.entities.db.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
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
}
