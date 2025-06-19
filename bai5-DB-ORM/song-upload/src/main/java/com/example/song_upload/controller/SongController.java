package com.example.song_upload.controller;

import com.example.song_upload.model.Song;
import com.example.song_upload.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    private static final String UPLOAD_DIR = "uploads";

    @GetMapping("")
    private String list(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "song/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "song/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Song song,
                       @RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String rootPath = System.getProperty("user.dir");
            Path uploadPath = Paths.get(rootPath,UPLOAD_DIR);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            Path filePath = uploadPath.resolve(fileName);
            file.transferTo(filePath.toFile());

            song.setFilePath("/uploads/" + fileName);
        }

        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        return "song/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Song song) {
        songService.update(song);
        return "redirect:/songs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        songService.delete(id);
        return "redirect:/songs";
    }

}
