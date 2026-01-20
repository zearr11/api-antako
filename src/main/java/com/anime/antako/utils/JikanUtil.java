package com.anime.antako.utils;

import com.anime.antako.entities.jikan.models.anime.AnimeJikan;
import com.anime.antako.entities.jikan.models.reusable.MalEntity;
import com.anime.antako.entities.jikan.models.title.Title;
import com.anime.antako.entities.db.enums.EmisionDay;
import com.anime.antako.entities.db.enums.Season;
import com.anime.antako.entities.db.enums.Type;
import java.util.ArrayList;
import java.util.List;

public class JikanUtil {

    public static List<String> getAlternativesTitles(AnimeJikan anime) {
        List<String> alternatives = new ArrayList<>();

        alternatives.add(anime.getTitle());
        alternatives.add(anime.getTitle_english());
        alternatives.add(anime.getTitle_japanese());

        alternatives.addAll(
                anime.getTitles()
                        .stream()
                        .map(Title::getTitle)
                        .toList()
        );

        alternatives.addAll(anime.getTitle_synonyms());

        return alternatives;
    }

    public static List<Long> getIDsGenres(AnimeJikan anime) {
        List<String> genres = new ArrayList<>();

        genres.addAll(anime.getGenres().stream().map(MalEntity::getName).toList());
        genres.addAll(anime.getDemographics().stream().map(MalEntity::getName).toList());

        return genres.stream().map(JikanUtil::genreToESP).toList();
    }

    public static Season translateSeasonToESP(String season) {
        return switch (season) {
            case "spring" -> Season.PRIMAVERA;
            case "winter" -> Season.INVIERNO;
            case "autumn", "fall" -> Season.OTONO;
            case "summer" -> Season.VERANO;
            default -> Season.NO_DEFINIDO;
        };
    }

    public static EmisionDay emissionDayToESP(String emissionDay) {
        return switch (emissionDay) {
            case "Mondays" -> EmisionDay.LUNES;
            case "Tuesdays" -> EmisionDay.MARTES;
            case "Wednesdays" -> EmisionDay.MIERCOLES;
            case "Thursdays" -> EmisionDay.JUEVES;
            case "Fridays" -> EmisionDay.VIERNES;
            case "Saturdays" -> EmisionDay.SABADO;
            case "Sundays" -> EmisionDay.DOMINGO;
            default -> EmisionDay.NO_DEFINIDO;
        };
    }

    public static Long genreToESP(String genre) {
        return switch (genre) {
            case "Action" -> 1L;
            case "Adventure" -> 2L;
            case "Avant Garde" -> 3L;
            case "Award Winning" -> 4L;
            case "Boys Love" -> 5L;
            case "Comedy" -> 6L;
            case "Drama" -> 7L;
            case "Fantasy" -> 8L;
            case "Girls Love" -> 9L;
            case "Gourmet" -> 10L;
            case "Horror" -> 11L;
            case "Mystery" -> 12L;
            case "Romance" -> 13L;
            case "Sci-Fi" -> 14L;
            case "Slice of Life" -> 15L;
            case "Sports" -> 16L;
            case "Supernatural" -> 17L;
            case "Suspense" -> 18L;
            case "Ecchi" -> 19L;
            case "Erotica" -> 20L;
            case "Hentai" -> 21L;
            case "Adult Cast" -> 22L;
            case "Anthropomorphic" -> 23L;
            case "CGDCT" -> 24L;
            case "Childcare" -> 25L;
            case "Combat Sports" -> 26L;
            case "Crossdressing" -> 27L;
            case "Delinquents" -> 28L;
            case "Detective" -> 29L;
            case "Educational" -> 30L;
            case "Gag Humor" -> 31L;
            case "Gore" -> 32L;
            case "Harem" -> 33L;
            case "High Stakes Game" -> 34L;
            case "Historical" -> 35L;
            case "Idols (Female)" -> 36L;
            case "Idols (Male)" -> 37L;
            case "Isekai" -> 38L;
            case "Iyashikei" -> 39L;
            case "Love Polygon" -> 40L;
            case "Magical Sex Shift" -> 41L;
            case "Mahou Shoujo" -> 42L;
            case "Martial Arts" -> 43L;
            case "Mecha" -> 44L;
            case "Medical" -> 45L;
            case "Military" -> 46L;
            case "Music" -> 47L;
            case "Mythology" -> 48L;
            case "Organized Crime" -> 49L;
            case "Otaku Culture" -> 50L;
            case "Parody" -> 51L;
            case "Performing Arts" -> 52L;
            case "Pets" -> 53L;
            case "Psychological" -> 54L;
            case "Racing" -> 55L;
            case "Reincarnation" -> 56L;
            case "Reverse Harem" -> 57L;
            case "Love Status Quo" -> 58L;
            case "Samurai" -> 59L;
            case "School" -> 60L;
            case "Showbiz" -> 61L;
            case "Space" -> 62L;
            case "Strategy Game" -> 63L;
            case "Super Power" -> 64L;
            case "Survival" -> 65L;
            case "Team Sports" -> 66L;
            case "Time Travel" -> 67L;
            case "Vampire" -> 68L;
            case "Video Game" -> 69L;
            case "Visual Arts" -> 70L;
            case "Workplace" -> 71L;
            case "Urban Fantasy" -> 72L;
            case "Villainess" -> 73L;
            case "Josei" -> 74L;
            case "Kids" -> 75L;
            case "Seinen" -> 76L;
            case "Shoujo" -> 77L;
            case "Shounen" -> 78L;
            default -> null;
        };
    }

    public static Type typeMapped(String type) {
        return switch (type) {
            case "TV" -> Type.TV_ANIME;
            case "Movie" -> Type.PELICULA;
            case "OVA" -> Type.OVA;
            case "Special" -> Type.ESPECIAL;
            case "Ona" -> Type.ONA;

            case "Music" -> Type.MUSICA;
            case "CM" -> Type.COMERCIAL;
            case "PV" -> Type.VIDEO_PROMOCIONAL;

            case "TV Special" -> Type.TV_ESPECIAL;
            default -> null;
        };
    }
}
