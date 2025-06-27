package com.codegym.controller;

import com.codegym.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LibraryController {
    @Autowired
    private LibraryService service;

    @GetMapping("")
    public String listBooks(Model model) {
        model.addAttribute("books", service.listBooks());
        return "list";
    }

    @GetMapping("/book/{id}")
    public String viewBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.getBook(id));
        return "detail";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long id, Model model) {
        String code = service.borrow(id);
        model.addAttribute("code", code);
        model.addAttribute("book", service.getBook(id));
        return "detail";
    }

    @GetMapping("/return")
    public String returnPage() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code) {
        service.returnBook(code);
        return "redirect:/";
    }
}
