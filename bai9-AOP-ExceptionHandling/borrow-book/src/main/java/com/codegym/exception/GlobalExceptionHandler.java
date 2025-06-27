package com.codegym.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e, Model model) {
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
