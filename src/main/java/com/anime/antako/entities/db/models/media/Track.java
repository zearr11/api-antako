package com.anime.antako.entities.db.models.media;

import com.anime.antako.entities.db.models.catalog.Anime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/*
    - SUB ENG
    - SUB ESP
    - AUDIO LATINO
    - AUDIO CASTELLANO
    - AUDIO INGLÉS
*/

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tracks")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String track;

    @ManyToMany
    @JoinTable(
            name = "anime_has_tracks",
            joinColumns = @JoinColumn(name = "id_track"),
            inverseJoinColumns = @JoinColumn(name = "id_anime")
    )
    private Set<Anime> animes = new HashSet<>();

}
