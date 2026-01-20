package com.anime.antako.services.interfaces;

import com.anime.antako.dto.request.AnimeRequest;
import com.anime.antako.entities.db.enums.EmisionDay;
import com.anime.antako.entities.db.models.catalog.Anime;

import java.time.LocalTime;

public interface IAnimeService {
    Anime getAnimeById(Long id);
    Anime getAnimeByCodJikan(Integer codJikan);

    void assignAlternativeTitleInAnime(Anime anime, String altTitle);
    void assignEntryReference(Anime anime);
    void assignCountriesTime(Anime anime, EmisionDay emisionDay, LocalTime emisionTime);

    String addAnimeInWeb (AnimeRequest request);
}
