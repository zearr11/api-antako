package com.anime.antako.dto.jikan.models.trailer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Trailer {

    private String youtube_id;
    private String url;
    private String embed_url;
    private TrailerImages images;

}
