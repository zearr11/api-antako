package com.anime.antako.repositories.catalog;

import com.anime.antako.models.catalog.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
