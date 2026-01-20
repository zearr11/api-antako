package com.anime.antako.dto.jikan.models.anime;

import com.anime.antako.dto.jikan.models.aired.Aired;
import com.anime.antako.dto.jikan.models.broadcast.Broadcast;
import com.anime.antako.dto.jikan.models.image.AnimeImages;
import com.anime.antako.dto.jikan.models.reusable.MalEntity;
import com.anime.antako.dto.jikan.models.title.Title;
import com.anime.antako.dto.jikan.models.trailer.Trailer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimeJikan {

    private int mal_id;
    private String url;
    private AnimeImages images;
    private Trailer trailer;
    private boolean approved;
    private List<Title> titles; // this

    private String title; // this
    private String title_english; // this
    private String title_japanese; // this
    private List<String> title_synonyms; // this

    private String type;
    private String source;
    private Integer episodes;
    private String status;
    private boolean airing;

    private Aired aired;
    private String duration;
    private String rating;

    private Double score;
    private Integer scored_by;
    private Integer rank;
    private Integer popularity;
    private Integer members;
    private Integer favorites;

    private String synopsis;
    private String background;

    private String season;
    private Integer year;

    private Broadcast broadcast;

    private List<MalEntity> producers;
    private List<MalEntity> licensors;
    private List<MalEntity> studios;
    private List<MalEntity> genres;
    private List<MalEntity> explicit_genres;
    private List<MalEntity> themes;
    private List<MalEntity> demographics;

}
