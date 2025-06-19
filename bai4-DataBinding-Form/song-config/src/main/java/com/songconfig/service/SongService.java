package com.songconfig.service;

import com.songconfig.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService {
    private static final List<Song> songs = new ArrayList<>();

    public static List<Song> findAll() {
        return songs;
    }

    public static void save(Song song) {
        songs.add(song);
    }
}
