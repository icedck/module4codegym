package com.codegym.controller;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.model.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("login", new Login());
        return mav;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        User user = UserDao.checkLogin(login);
        ModelAndView mav;
        if (user == null) {
            mav = new ModelAndView("error");
        }
        else {
            mav = new ModelAndView("user");
            mav.addObject("user", user);
        }
        return mav;
    }
}
