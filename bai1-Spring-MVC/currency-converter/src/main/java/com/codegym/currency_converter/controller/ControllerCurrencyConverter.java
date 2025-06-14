package com.codegym.currency_converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerCurrencyConverter {
    private static final double RATE = 25000;

    @GetMapping("/")
    public String showConverterForm() {
        return "converter";
    }

    @PostMapping("/convert")
    private String convert(@RequestParam double usd, Model model) {
        if (usd < 0) {
            model.addAttribute("error", "Please enter a positive number");
            return "converter";
        }
        double vnd = usd * RATE;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        return "converter";
    }
}
