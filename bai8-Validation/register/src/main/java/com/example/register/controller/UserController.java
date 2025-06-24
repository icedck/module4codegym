package com.example.register.controller;

import com.example.register.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("register")
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView("views/index");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("validate")
    public ModelAndView checkValidition(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("views/index");
        }
        return new ModelAndView("views/result");
    }
}
