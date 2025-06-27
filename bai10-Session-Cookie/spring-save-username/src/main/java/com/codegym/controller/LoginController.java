package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    // Tạo một đối tượng User mặc định trong model
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    // Hiển thị form login và lấy email từ cookie nếu có
    @GetMapping("/login")
    public String showLoginForm(@CookieValue(value = "setUser", defaultValue = "") String setUser,
                                @ModelAttribute("user") User user) {
        user.setEmail(setUser); // Gán giá trị từ cookie vào email
        return "/login";
    }

    // Xử lý đăng nhập
    @PostMapping("/doLogin")
    public String doLogin(@ModelAttribute("user") User user,
                          Model model,
                          HttpServletResponse response) {

        String email = user.getEmail();
        String password = user.getPassword();

        if ("admin@gmail.com".equals(email) && "123456".equals(password)) {
            // Đăng nhập thành công → lưu cookie
            Cookie cookie = new Cookie("setUser", email);
            cookie.setMaxAge(24 * 60 * 60); // 1 ngày
            response.addCookie(cookie);

            model.addAttribute("message", "Login success. Welcome!");
        } else {
            // Đăng nhập thất bại
            user.setEmail(""); // reset lại email để không hiển thị
            Cookie cookie = new Cookie("setUser", "");
            cookie.setMaxAge(0); // xóa cookie
            response.addCookie(cookie);

            model.addAttribute("message", "Login failed. Try again.");
        }

        return "/login";
    }
}
