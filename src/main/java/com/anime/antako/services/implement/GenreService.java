package com.anime.antako.services.implement;

import com.anime.antako.entities.db.models.catalog.Anime;
import com.anime.antako.entities.db.models.catalog.Genre;
import com.anime.antako.repositories.catalog.GenreRepository;
import com.anime.antako.services.interfaces.IGenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService implements IGenreService {
    private final GenreRepository genreRepository;

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElseThrow(() -> new RuntimeException("Genre Not Found"));
    }

    @Override
    public void assignGenresToAnime(Anime anime, List<Long> idGenres) {
        idGenres.forEach((id) -> {
           Genre genreToAssign = getGenreById(id);
           genreToAssign.addAnime(anime);

           genreRepository.save(genreToAssign);
        });
    }
}
