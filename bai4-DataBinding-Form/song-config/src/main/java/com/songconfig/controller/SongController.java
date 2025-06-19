package com.songconfig.controller;

import com.songconfig.model.Song;
import com.songconfig.service.SongService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class SongController {

    private final List<String> allowedExtensions = Arrays.asList("mp3", "wav", "ogg", "m4p");

    @GetMapping("/songs/list")
    public String listSongs(Model model) {
        model.addAttribute("songs", SongService.findAll());
        return "list";
    }

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("/songs/upload")
    public String showUploadForm(Model model) {
        return "upload";
    }

    @PostMapping("/songs/upload")
    public String uploadSong(@RequestParam String name,
                             @RequestParam String artist,
                             @RequestParam String genre,
                             @RequestParam("file") MultipartFile file,
                             Model model) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        if (fileName == null || fileName.isEmpty()) {
            model.addAttribute("error", "Please select a file");
            return "upload";
        }

        String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        if (!allowedExtensions.contains(extension)) {
            model.addAttribute("error", "Chỉ chấp nhận .mp3, .wav, .ogg, .m4p");
            return "upload";
        }

        File uploadDir = new File(fileUpload);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String filePath = uploadDir.getAbsolutePath() + File.separator + fileName;
        file.transferTo(new File(filePath));

        SongService.save(new Song(name, artist, genre, "/uploads/" + fileName));
        return "redirect:/songs/list";
    }
}
