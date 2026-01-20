package com.anime.antako.services.interfaces;

import com.anime.antako.dto.jikan.enums.*;
import com.anime.antako.dto.jikan.models.JikanResponse;
import com.anime.antako.dto.response.JikanAnimeResponse;
import com.anime.antako.dto.response.PaginatedResponse;

import java.util.List;

public interface IJikanService {

    JikanResponse getAnimeSearchFull(Boolean unapproved, Integer page, Integer limit,
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
