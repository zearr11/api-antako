package com.anime.antako.models.catalog;

import com.anime.antako.enums.EmisionDay;
import com.anime.antako.models.group.Seasonal;
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

    // RELATIONAL PROPERTIES
    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_state")
    private State state;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_type")
    private Type type;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_seasonal")
    private Seasonal seasonal;

    /*
    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_saga")
    private Saga saga;
    */

    // READING PROPERTIES
    @ManyToMany(mappedBy = "animes")
    private Set<Genre> genres = new HashSet<>();

}
