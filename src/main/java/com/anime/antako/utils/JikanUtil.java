package com.anime.antako.utils;

import com.anime.antako.dto.jikan.models.anime.AnimeJikan;
import com.anime.antako.dto.jikan.models.reusable.MalEntity;
import com.anime.antako.dto.jikan.models.title.Title;
import com.anime.antako.enums.EmisionDay;
import com.anime.antako.enums.specials.Genre;
import com.anime.antako.enums.specials.Season;
import com.anime.antako.enums.specials.Type;

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

    public static List<Genre> getGenres(AnimeJikan anime) {
        List<String> genres = new ArrayList<>();

        genres.addAll(anime.getGenres().stream().map(MalEntity::getName).toList());
        genres.addAll(anime.getDemographics().stream().map(MalEntity::getName).toList());

        return genres.stream().map(JikanUtil::genreToESP).toList();
    }

    // TODO
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

    public static Genre genreToESP(String genre) {
        return switch (genre) {
            case "Action" -> Genre.ACCION;
            case "Adventure" -> Genre.AVENTURA;
            case "Avant Garde" -> Genre.VANGUARDIA;
            case "Award Winning" -> Genre.PREMIADO;
            case "Boys Love" -> Genre.AMOR_ENTRE_CHICOS;
            case "Comedy" -> Genre.COMEDIA;
            case "Drama" -> Genre.DRAMA;
            case "Fantasy" -> Genre.FANTASIA;
            case "Girls Love" -> Genre.AMOR_ENTRE_CHICAS;
            case "Gourmet" -> Genre.GASTRONOMIA;
            case "Horror" -> Genre.TERROR;
            case "Mystery" -> Genre.MISTERIO;
            case "Romance" -> Genre.ROMANCE;
            case "Sci-Fi" -> Genre.CIENCIA_FICCION;
            case "Slice of Life" -> Genre.RECUENTOS_DE_LA_VIDA;
            case "Sports" -> Genre.DEPORTES;
            case "Supernatural" -> Genre.SOBRENATURAL;
            case "Suspense" -> Genre.SUSPENSO;
            case "Ecchi" -> Genre.ECCHI;
            case "Erotica" -> Genre.EROTICO;
            case "Hentai" -> Genre.HENTAI;
            case "Adult Cast" -> Genre.ELENCO_ADULTO;
            case "Anthropomorphic" -> Genre.ANTROPOMORFICO;
            case "CGDCT" -> Genre.CGDCT;
            case "Childcare" -> Genre.CUIDADO_DE_NINOS;
            case "Combat Sports" -> Genre.DEPORTES_DE_COMBATE;
            case "Crossdressing" -> Genre.TRAVESTISMO;
            case "Delinquents" -> Genre.DELINCUENTES;
            case "Detective" -> Genre.DETECTIVES;
            case "Educational" -> Genre.EDUCATIVO;
            case "Gag Humor" -> Genre.HUMOR_ABSURDO;
            case "Gore" -> Genre.GORE;
            case "Harem" -> Genre.HAREM;
            case "High Stakes Game" -> Genre.JUEGOS_DE_ALTO_RIESGO;
            case "Historical" -> Genre.HISTORICO;
            case "Idols (Female)" -> Genre.IDOLS_FEMENINAS;
            case "Idols (Male)" -> Genre.IDOLS_MASCULINOS;
            case "Isekai" -> Genre.ISEKAI;
            case "Iyashikei" -> Genre.IYASHIKEI;
            case "Love Polygon" -> Genre.POLIGONO_AMOROSO;
            case "Magical Sex Shift" -> Genre.CAMBIO_DE_SEXO_MAGICO;
            case "Mahou Shoujo" -> Genre.CHICAS_MAGICAS;
            case "Martial Arts" -> Genre.ARTES_MARCIALES;
            case "Mecha" -> Genre.MECHA;
            case "Medical" -> Genre.MEDICO;
            case "Military" -> Genre.MILITAR;
            case "Music" -> Genre.MUSICA;
            case "Mythology" -> Genre.MITOLOGIA;
            case "Organized Crime" -> Genre.CRIMEN_ORGANIZADO;
            case "Otaku Culture" -> Genre.CULTURA_OTAKU;
            case "Parody" -> Genre.PARODIA;
            case "Performing Arts" -> Genre.ARTES_ESCENICAS;
            case "Pets" -> Genre.MASCOTAS;
            case "Psychological" -> Genre.PSICOLOGICO;
            case "Racing" -> Genre.CARRERAS;
            case "Reincarnation" -> Genre.REENCARNACION;
            case "Reverse Harem" -> Genre.REVERSE_HAREM;
            case "Love Status Quo" -> Genre.AMOR_ESTATICO;
            case "Samurai" -> Genre.SAMURAI;
            case "School" -> Genre.ESCOLAR;
            case "Showbiz" -> Genre.FARANDULA;
            case "Space" -> Genre.ESPACIO;
            case "Strategy Game" -> Genre.JUEGOS_DE_ESTRATEGIA;
            case "Super Power" -> Genre.SUPER_PODERES;
            case "Survival" -> Genre.SUPERVIVENCIA;
            case "Team Sports" -> Genre.DEPORTES_EN_EQUIPO;
            case "Time Travel" -> Genre.VIAJES_EN_EL_TIEMPO;
            case "Vampire" -> Genre.VAMPIROS;
            case "Video Game" -> Genre.VIDEOJUEGOS;
            case "Visual Arts" -> Genre.ARTES_VISUALES;
            case "Workplace" -> Genre.LUGAR_DE_TRABAJO;
            case "Urban Fantasy" -> Genre.FANTASIA_URBANA;
            case "Villainess" -> Genre.VILLANA;
            case "Josei" -> Genre.JOSEI;
            case "Kids" -> Genre.INFANTIL;
            case "Seinen" -> Genre.SEINEN;
            case "Shoujo" -> Genre.SHOUJO;
            case "Shounen" -> Genre.SHOUNEN;
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
