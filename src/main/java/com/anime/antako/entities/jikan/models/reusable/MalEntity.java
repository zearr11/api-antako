package com.anime.antako.entities.jikan.models.reusable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MalEntity {

    private int mal_id;
    private String type;
    private String name;
    private String url;

}
