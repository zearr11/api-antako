package com.anime.antako.controllers;

import com.anime.antako.entities.jikan.enums.AnimeStatus;
import com.anime.antako.dto.response.JikanAnimeResponse;
import com.anime.antako.dto.generics.PaginatedResponse;
import com.anime.antako.services.interfaces.IJikanService;
import com.anime.antako.dto.generics.ResponseStatus;
import com.anime.antako.dto.generics.GeneralResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${app.prefix}/jikan")
public class JikanController {

    private final IJikanService jikanService;

    @GetMapping
    public ResponseEntity<GeneralResponse<
            PaginatedResponse<List<JikanAnimeResponse>>>> getAnimeSearchMin(@RequestParam(required = false) Integer page,
                                                                            @RequestParam(required = false) Integer limit,
                                                                            @RequestParam(required = false) String q,
                                                                            @RequestParam(required = false) AnimeStatus status) {
        return ResponseEntity.ok(
                GeneralResponse.<PaginatedResponse<List<JikanAnimeResponse>>>builder()
                        .status(ResponseStatus.SUCCESS)
                        .data(jikanService.getAnimeSearchMin(page, limit, q, status))
                        .build()
        );
    }

    @GetMapping("/{codJikan}")
    public ResponseEntity<GeneralResponse<JikanAnimeResponse>> getAnimeById(@PathVariable Integer codJikan) {

        return ResponseEntity.ok(
                GeneralResponse.<JikanAnimeResponse>builder()
                        .status(ResponseStatus.SUCCESS)
                        .data(jikanService.getAnimeById(codJikan))
                        .build()
        );
    }

}
