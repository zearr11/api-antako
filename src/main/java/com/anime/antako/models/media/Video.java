package com.anime.antako.models.media;

import com.anime.antako.models.catalog.Episode;
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
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_track")
    private Track track;

    @ManyToOne
    @JoinColumn(nullable = false, name = "fk_id_episode")
    private Episode episode;

}
