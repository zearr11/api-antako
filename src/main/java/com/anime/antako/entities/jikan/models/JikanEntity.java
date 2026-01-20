package com.anime.antako.entities.jikan.models;

import com.anime.antako.entities.jikan.models.anime.AnimeJikan;
import com.anime.antako.entities.jikan.models.pagination.Pagination;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JikanEntity {

    private Pagination pagination;
    private List<AnimeJikan> data;

}
