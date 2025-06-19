package com.codegym.controller;

import com.codegym.model.Mail;
import com.codegym.service.MailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

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
//

    @GetMapping("")
    public String showForm(Model model) {
        Mail mail = new Mail();
        mail.setLanguage("English");  // Set default values
        mail.setPageSize(25);
        mail.setSpamFilter(false);
        mail.setSignature("Thor\nKing, Asgard");

        // Sử dụng Arrays.asList() thay vì List.of()
        model.addAttribute("mail", mail);  // Dùng 'mail' thay vì 'settings'
        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", new int[]{5, 10, 15, 25, 50, 100});

        return "mails";  // View "mails.html"
    }


    @PostMapping("/save")
    public String updateSettings(@ModelAttribute("mail") Mail mail, Model model) {
        model.addAttribute("mail", mail);  // Pass updated 'mail' object to view
        return "maildetail";  // Return a different view (e.g. 'maildetail.html')
    }

}