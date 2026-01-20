package com.anime.antako.entities.jikan.models.image;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageSet {

    private String image_url;
    private String small_image_url;
    private String large_image_url;

}
