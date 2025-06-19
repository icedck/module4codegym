package com.example.song_upload.service;

import com.example.song_upload.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    void save(Song song);
    void update(Song song);
    void delete(int id);
}
