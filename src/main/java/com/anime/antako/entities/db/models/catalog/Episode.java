package com.anime.antako.entities.db.models.catalog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer chapterNumber;

    @Column(nullable = false)
    private Double duration;

    @Column(nullable = false)
    private LocalDateTime broadcastDate;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_anime")
    private Anime anime;

}
