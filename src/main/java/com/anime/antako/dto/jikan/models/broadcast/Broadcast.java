package com.anime.antako.dto.jikan.models.broadcast;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Broadcast {

    private String day;
    private String time;
    private String timezone;
    private String string;

}
