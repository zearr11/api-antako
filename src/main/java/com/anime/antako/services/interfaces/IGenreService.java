package com.anime.antako.services.interfaces;

import com.anime.antako.entities.db.models.catalog.Anime;
import com.anime.antako.entities.db.models.catalog.Genre;
import java.util.List;

public interface IGenreService {
    Genre getGenreById(Long id);

    void assignGenresToAnime(Anime anime, List<Long> idGenres);
}
