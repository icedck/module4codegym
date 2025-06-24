package com.example.musicapp_validation.service;

import com.example.musicapp_validation.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(Long id);
    void save(Song song);
}
