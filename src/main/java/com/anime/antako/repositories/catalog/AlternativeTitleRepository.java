package com.anime.antako.repositories.catalog;

import com.anime.antako.entities.db.models.catalog.AlternativeTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlternativeTitleRepository extends JpaRepository<AlternativeTitle, Long> {
}
