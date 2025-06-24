package com.example.musicapp_validation.repository;

import com.example.musicapp_validation.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepo extends JpaRepository<Song, Long> {
}
