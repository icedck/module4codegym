package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {

    @GetMapping("/")
    public String sandwichCondiments() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
        model.addAttribute("condiments", condiment);
        return "result";
    }
}
