package com.anime.antako.services.interfaces;

import com.anime.antako.entities.jikan.enums.*;
import com.anime.antako.entities.jikan.models.JikanEntity;
import com.anime.antako.dto.response.JikanAnimeResponse;
import com.anime.antako.dto.generics.PaginatedResponse;

import java.util.List;

public interface IJikanService {

    JikanEntity getAnimeSearchFull(Boolean unapproved, Integer page, Integer limit,
                                   String q, AnimeType type, Double score, Double min_score,
                                   Double max_score, AnimeStatus status, AnimeRating rating,
                                   Boolean sfw, String genres, String genres_exclude,
                                   AnimeOrderBy order_by, SortDirection sort, String letter, String producers,
                                   String start_date, String end_date);

    PaginatedResponse<List<JikanAnimeResponse>> getAnimeSearchMin(Integer page, Integer limit,
                                                                  String q, AnimeStatus status);

    JikanAnimeResponse getAnimeById(Integer anime_id);

    // JikanResponse & JikanResponse2
}
