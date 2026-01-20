package com.anime.antako.services.implement;

import com.anime.antako.dto.request.AnimeRequest;
import com.anime.antako.entities.db.enums.Country;
import com.anime.antako.entities.db.enums.EmisionDay;
import com.anime.antako.entities.db.models.catalog.AlternativeTitle;
import com.anime.antako.entities.db.models.catalog.Anime;
import com.anime.antako.entities.db.models.catalog.CountryTime;
import com.anime.antako.entities.db.models.related.Entry;
import com.anime.antako.repositories.catalog.AlternativeTitleRepository;
import com.anime.antako.repositories.catalog.AnimeRepository;
import com.anime.antako.repositories.catalog.CountryTimeRepository;
import com.anime.antako.repositories.related.EntryRepository;
import com.anime.antako.services.interfaces.IAnimeService;
import com.anime.antako.services.interfaces.IGenreService;
import com.anime.antako.utils.CountryTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class AnimeService implements IAnimeService {
    private final AnimeRepository animeRepository;
    private final EntryRepository entryRepository;
    private final AlternativeTitleRepository alterTitleRepository;
    private final CountryTimeRepository countryTimeRepository;

    private final IGenreService genreService;

    @Override
    public Anime getAnimeById(Long id) {
        return animeRepository.findById(id).orElseThrow(() -> new RuntimeException("Anime not found"));
    }

    @Override
    public Anime getAnimeByCodJikan(Integer codJikan) {
        return animeRepository.findByCodJikan(codJikan).orElseThrow(() -> new RuntimeException("Anime not found"));
    }

    @Override
    public void assignAlternativeTitleInAnime(Anime anime, String altTitle) {
        AlternativeTitle newAltTitle = new AlternativeTitle(
                null,
                altTitle,
                anime
        );

        alterTitleRepository.save(newAltTitle);
    }

    @Override
    public void assignEntryReference(Anime anime) {
        Entry entry = new Entry(null, anime);
        entryRepository.save(entry);
    }

    @Override
    public void assignCountriesTime(Anime anime, EmisionDay emisionDay, LocalTime emisionTime) {
        if (EmisionDay.NO_DEFINIDO == emisionDay || emisionTime == null) return;

        for (Country country : Country.values()) {
            CountryTime countryTime = CountryTimeUtil.createCountryTime(country, emisionDay, emisionTime);
            countryTime.setAnime(anime);

            countryTimeRepository.save(countryTime);
        }
    }

    @Transactional
    @Override
    public String addAnimeInWeb(AnimeRequest request) {
        // Creación de anime
        Anime anime = animeRepository.save(
                new Anime(null,
                        request.getCodJikan(),
                        request.getUrlImage(),
                        request.getTitle(),
                        request.getDescription(),
                        request.getRating(),
                        request.getEmisionDay(),
                        LocalDateTime.now(),
                        request.getState(),
                        request.getType(),
                        request.getSeason(),
                        request.getYear(),
                        null)
        );

        // Asignación a referencia de anime para futuras relaciones
        assignEntryReference(anime);

        // Asignación de títulos alternativos
        request.getAlternativeTitles().forEach(altTitle -> assignAlternativeTitleInAnime(anime, altTitle));

        // Asignación de géneros
        genreService.assignGenresToAnime(anime, request.getIdGenres());

        // Asignación de horarios en caso esté en emisión o tenga sus datos de emisión
        assignCountriesTime(anime, request.getEmisionDay(), request.getEmisionTime());

        return "Anime created successfully";
    }
}
