package com.anime.antako.entities.jikan.models.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaginationItems {

    private int count;
    private int total;
    private int per_page;

}
