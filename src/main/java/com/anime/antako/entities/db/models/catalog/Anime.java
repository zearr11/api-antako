package com.anime.antako.entities.db.models.catalog;

import com.anime.antako.entities.db.enums.EmisionDay;
import com.anime.antako.entities.db.enums.Genre;
import com.anime.antako.entities.db.enums.Season;
import com.anime.antako.entities.db.enums.State;
import com.anime.antako.entities.db.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "animes")
public class Anime {

    // REGULAR PROPERTIES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Integer codJikan;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String urlImage;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EmisionDay emissionDay;

    @Column(nullable = false)
    private LocalDateTime uploadDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private State state;

    // RELATIONAL PROPERTIES
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Season season;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(
            name = "anime_has_genres",
            joinColumns = @JoinColumn(name = "anime_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "genres")
    private Set<Genre> genres = new HashSet<>();

}
