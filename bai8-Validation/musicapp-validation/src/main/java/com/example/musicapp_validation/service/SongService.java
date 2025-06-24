package com.example.musicapp_validation.service;

import com.example.musicapp_validation.model.Song;
import com.example.musicapp_validation.repository.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    SongRepo songRepo;

    @Override
    public List<Song> findAll() {
        return songRepo.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepo.findById(id).get();
    }

    @Override
    public void save(Song song) {
        songRepo.save(song);
    }
}
