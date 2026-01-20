package com.anime.antako.entities.jikan.models.trailer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrailerImages {

    private String image_url;
    private String small_image_url;
    private String medium_image_url;
    private String large_image_url;
    private String maximum_image_url;

}
