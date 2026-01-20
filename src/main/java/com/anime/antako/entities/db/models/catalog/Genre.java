package com.anime.antako.entities.db.models.catalog;

/*
    - Aventura
    - Comedia
    - Fantasía
    - ...
*/

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String genre;

    @ManyToMany
    @JoinTable(
            name = "anime_has_genres",
            joinColumns = @JoinColumn(name = "id_genre"),
            inverseJoinColumns = @JoinColumn(name = "id_anime")
    )
    private Set<Anime> animes = new HashSet<>();

    public void addAnime(Anime anime) {
        animes.add(anime);
    }
}
