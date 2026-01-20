package com.anime.antako.repositories.related;

import com.anime.antako.entities.db.models.related.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
