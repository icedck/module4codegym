package com.example.musicapp_validation.controller;

import com.example.musicapp_validation.model.Song;
import com.example.musicapp_validation.service.ISongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "song/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new Song());
        return "song/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "song/create";
        }
        songService.save(song);
        return "redirect:/songs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        if (song != null) {
            model.addAttribute("song", song);
            return "song/edit";
        }
        return "redirect:/songs";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Song song, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "song/edit";
        }
        songService.save(song);
        return "redirect:/songs";
    }
}
