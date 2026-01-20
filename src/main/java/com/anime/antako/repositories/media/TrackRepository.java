package com.anime.antako.repositories.media;

import com.anime.antako.entities.db.models.media.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long> {
}
