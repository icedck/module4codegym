package com.codegym.dictionary.controller;

import com.codegym.dictionary.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/")
    public String showDictionaryForm() {
        return "dictionary";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String word, Model model) {
        if (word == null || word.trim().isEmpty()) {
            model.addAttribute("error", "Please enter a word");
            return "dictionary";
        }
        String translatedWord = dictionaryService.translate(word);
        if (translatedWord == null) {
            model.addAttribute("error", "Could not translate word: " + word);
            model.addAttribute("word", word);
            return "dictionary";
        }
        model.addAttribute("word", word);
        model.addAttribute("translatedWord", translatedWord);
        return "dictionary";
    }
}
