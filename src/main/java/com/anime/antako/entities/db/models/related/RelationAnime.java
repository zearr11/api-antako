package com.anime.antako.entities.db.models.related;

import com.anime.antako.entities.db.models.catalog.Anime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "relation_animes")
public class RelationAnime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_relation")
    private Relation relation;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_contextual_anime")
    private Anime contextualAnime;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_anime_entry")
    private Entry animeEntry;

}
