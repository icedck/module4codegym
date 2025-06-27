package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView mav = new ModelAndView("shop");
        mav.addObject("products", productService.findAll());
        return mav;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(product.get());
        return "redirect:/shop";
    }
}
