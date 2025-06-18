package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mails")
public class MailController {
//    @GetMapping("")
//    public String showForm(Model model) {
//        model.addAttribute("mail", MailService.get());
//        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
//        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});
//        return "mails";
//    }
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute("mail") Mail mail) {
//        MailService.save(mail);
//        return "maildetail";
//    }

    @GetMapping("")
    public String showForm(Model model) {
        Mail settings = new Mail();
        settings.setLanguage("English");
        settings.setPageSize(25);
        settings.setSpamFilter(false);
        settings.setSignature("Thor\nKing, Asgard");

        model.addAttribute("settings", settings);
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});

        return "mails";
    }

    @PostMapping("/save")
    public String updateSettings(@ModelAttribute Mail mail, Model model) {
        model.addAttribute("mails", mail);
        return "maildetail";
    }
}
