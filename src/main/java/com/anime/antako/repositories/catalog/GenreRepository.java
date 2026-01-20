package com.anime.antako.repositories.catalog;

import com.anime.antako.entities.db.models.catalog.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
