package com.anime.antako.dto.jikan.models;

import com.anime.antako.dto.jikan.models.anime.AnimeJikan;
import com.anime.antako.dto.jikan.models.pagination.Pagination;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JikanResponse {

    private Pagination pagination;
    private List<AnimeJikan> data;

}
