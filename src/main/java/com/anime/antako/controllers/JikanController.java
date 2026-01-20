package com.anime.antako.controllers;

import com.anime.antako.dto.jikan.enums.AnimeStatus;
import com.anime.antako.dto.response.GeneralResponse;
import com.anime.antako.dto.response.JikanAnimeResponse;
import com.anime.antako.dto.response.PaginatedResponse;
import com.anime.antako.services.interfaces.IJikanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("${app.prefix}/jikan")
@RequiredArgsConstructor
public class JikanController {

    private final IJikanService jikanService;

    @GetMapping
    public ResponseEntity<GeneralResponse<PaginatedResponse<List<JikanAnimeResponse>>>> getAnimeSearchMin(Integer page, Integer limit,
                                                                                                          String q, AnimeStatus status) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new GeneralResponse<>(
                        "success",
                        jikanService.getAnimeSearchMin(page, limit, q, status
                        ),
                        null
                )
        );
    }

    /*
    @GetMapping("/{codJikan}")
    public ResponseEntity<JikanResponse2> getAnimeById(@PathVariable Integer codJikan) {
        return ResponseEntity.status(HttpStatus.OK).body(jikanService.getAnimeById(codJikan));
    }
    */

}
