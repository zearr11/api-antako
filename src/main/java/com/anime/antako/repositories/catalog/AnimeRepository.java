package com.anime.antako.repositories.catalog;

import com.anime.antako.entities.db.models.catalog.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
    Optional<Anime> findByCodJikan(Integer codJikan);
}
