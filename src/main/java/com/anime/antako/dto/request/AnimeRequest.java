package com.anime.antako.dto.request;

import com.anime.antako.entities.db.enums.EmisionDay;
import com.anime.antako.entities.db.enums.Season;
import com.anime.antako.entities.db.enums.State;
import com.anime.antako.entities.db.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnimeRequest {

    private Integer codJikan;
    private String urlImage;
    private String title;
    private String description;
    private Double rating; // OPCIONAL
    private State state;
    private Type type;
    private Season season; // NO_DEFINIDO en caso no este presente
    private Integer year;
    private List<Long> idGenres;
    private List<String> alternativeTitles; // OPCIONAL

    private EmisionDay emisionDay; // NO_DEFINIDO en caso no este presente
    private LocalTime emisionTime; // OPCIONAL

}
