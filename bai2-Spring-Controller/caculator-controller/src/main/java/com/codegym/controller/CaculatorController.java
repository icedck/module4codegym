package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {
    @GetMapping("/")
    public String showCaculator() {
        return "index";
    }

    @PostMapping("/caculate")
    public String caculate(@RequestParam double num1, @RequestParam float num2, @RequestParam char operator, Model model) {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                }else {
                    model.addAttribute("error", "cannot divide by zero");
                    return "index";
                }
                break;
        }
        model.addAttribute("result", result);
        return "index";
    }
}
