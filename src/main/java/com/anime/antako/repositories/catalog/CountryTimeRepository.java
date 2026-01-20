package com.anime.antako.repositories.catalog;

import com.anime.antako.entities.db.models.catalog.CountryTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryTimeRepository extends JpaRepository<CountryTime, Long> {
}
