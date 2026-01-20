package com.anime.antako.dto.jikan.models.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pagination {

    private int last_visible_page;
    private boolean has_next_page;
    private int current_page;
    private PaginationItems items;

}
