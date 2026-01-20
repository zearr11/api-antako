package com.anime.antako.dto.response;

import com.anime.antako.entities.jikan.models.anime.AnimeJikan;
import com.anime.antako.entities.db.enums.EmisionDay;
import com.anime.antako.entities.db.enums.Genre;
import com.anime.antako.entities.db.enums.Season;
import com.anime.antako.entities.db.enums.State;
import com.anime.antako.entities.db.enums.Type;
import com.anime.antako.utils.JikanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JikanAnimeResponse {

    private Integer codJikan;
    private String urlWebp;

    private String title;
    private List<String> titlesAlternatives;

    private Type type;
    private State status;

    private Double rating;

    private Season season;
    private Integer year;

    private EmisionDay emissionDay;
    private LocalTime emissionTime;
    private String timeZone;

    private List<Genre> genres;

    public static JikanAnimeResponse mappedJikan(AnimeJikan anime) {

        int codJikan = anime.getMal_id();
        String urlImage = anime.getImages().getWebp().getImage_url();

        String title = anime.getTitle();
        List<String> alternatives = JikanUtil.getAlternativesTitles(anime);

        Type type = JikanUtil.typeMapped(anime.getType());
        State status = anime.isAiring() ? State.EN_EMISION : State.FINALIZADO;

        Double rating = anime.getScore();

        Season season = JikanUtil.translateSeasonToESP(
                anime.getSeason() != null ? anime.getSeason() : "");
        Integer year = anime.getYear();

        EmisionDay emissionDay = JikanUtil.emissionDayToESP(
                anime.getBroadcast().getDay() != null ? anime.getBroadcast().getDay() : ""
        );
        LocalTime emissionTime = anime.getBroadcast().getTime() != null ? LocalTime.parse(anime.getBroadcast().getTime()) : null;
        String timeZone = anime.getBroadcast().getTimezone();

        List<Genre> genres = JikanUtil.getGenres(anime);

        return new JikanAnimeResponse(
                codJikan, urlImage, title, alternatives, type, status,
                rating, season, year, emissionDay, emissionTime, timeZone, genres
        );
    }

}
