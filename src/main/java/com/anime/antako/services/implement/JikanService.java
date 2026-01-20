package com.anime.antako.services.implement;

import com.anime.antako.entities.jikan.enums.*;
import com.anime.antako.entities.jikan.models.JikanEntity;
import com.anime.antako.dto.response.JikanAnimeResponse;
import com.anime.antako.dto.generics.PaginatedResponse;
import com.anime.antako.entities.jikan.models.JikanEntity2;
import com.anime.antako.services.interfaces.IJikanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JikanService implements IJikanService {

    private final WebClient webClient;

    @Override
    public JikanEntity getAnimeSearchFull(Boolean unapproved, Integer page, Integer limit,
                                          String q, AnimeType type, Double score,
                                          Double min_score, Double max_score,
                                          AnimeStatus status, AnimeRating rating,
                                          Boolean sfw, String genres, String genres_exclude,
                                          AnimeOrderBy order_by, SortDirection sort,
                                          String letter, String producers, String start_date,
                                          String end_date) {
        return null;
    }

    @Override
    public PaginatedResponse<List<JikanAnimeResponse>> getAnimeSearchMin(Integer page, Integer limit,
                                                                         String q, AnimeStatus status) {
        JikanEntity result = webClient.get()
                .uri(uriBuilder -> {
                    uriBuilder.path("/anime");

                    Optional.ofNullable(page)
                            .ifPresent(v -> uriBuilder.queryParam("page", v));

                    Optional.ofNullable(limit)
                            .ifPresent(v -> uriBuilder.queryParam("limit", v));

                    if (q != null && !q.isBlank())
                        uriBuilder.queryParam("q", q);

                    Optional.ofNullable(status)
                            .map(AnimeStatus::getValue)
                            .ifPresent(v -> uriBuilder.queryParam("status", v));

                    return uriBuilder.build();
                })
                .retrieve()
                .bodyToMono(JikanEntity.class)
                .block();

        if (result == null) return null;

        List<JikanAnimeResponse> data = result.getData().stream().map(JikanAnimeResponse::mappedJikan).toList();

        return new PaginatedResponse<>(
                result.getPagination().getCurrent_page(),
                result.getPagination().getItems().getPer_page(),
                result.getPagination().getItems().getCount(),
                result.getPagination().getItems().getTotal(),
                result.getPagination().getLast_visible_page(),
                data
        );
    }

    @Override
    public JikanAnimeResponse getAnimeById(Integer anime_id) {
        JikanEntity2 result = webClient.get()
                .uri("/anime/{anime_id}", anime_id)
                .retrieve()
                .bodyToMono(JikanEntity2.class)
                .block();

        return result == null ?
                null :
                JikanAnimeResponse.mappedJikan(result.getData());
    }

}
