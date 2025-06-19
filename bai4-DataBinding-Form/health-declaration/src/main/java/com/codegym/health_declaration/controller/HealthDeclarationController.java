package com.codegym.health_declaration.controller;

import com.codegym.health_declaration.model.HealthDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/declaration")
public class HealthDeclarationController {

    private List<HealthDeclaration> declarations = new ArrayList<>();

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("healthDeclaration", new HealthDeclaration());
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute HealthDeclaration healthDeclaration) {
        declarations.add(healthDeclaration);
        return "redirect:/declaration/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("declarations", declarations);
        return "list";
    }
}
