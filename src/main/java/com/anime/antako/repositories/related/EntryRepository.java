package com.anime.antako.repositories.related;

import com.anime.antako.models.related.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
