package com.anime.antako.repositories.related;

import com.anime.antako.entities.db.models.related.RelationAnime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationAnimeRepository extends JpaRepository<RelationAnime, Long> {
}
