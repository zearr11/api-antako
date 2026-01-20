package com.anime.antako.entities.db.models.catalog;

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
@Table(name = "alternative_titles")
public class AlternativeTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String alternativeTitle;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_anime")
    private Anime anime;

}
