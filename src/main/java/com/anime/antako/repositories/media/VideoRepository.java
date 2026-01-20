package com.anime.antako.repositories.media;

import com.anime.antako.entities.db.models.media.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
