package com.anime.antako.dto.jikan.models.aired;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aired {

    private OffsetDateTime from;
    private OffsetDateTime to;
    private AiredProp prop;
    private String string;

}
