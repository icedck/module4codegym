package com.codegym.controller;

import com.codegym.model.Cart;
import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class CartController {
    @Autowired
    private ProductService productService;

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable int id, HttpSession session) {
        Product product = productService.findById(id);
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.add(product);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/cart/update")
    public String updateQuantity(@RequestParam int id, @RequestParam int quantity, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) cart.update(id, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeItem(@PathVariable int id, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) cart.remove(id);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session, RedirectAttributes redirectAttributes) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null || cart.getItems().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Giỏ hàng trống");
            return "redirect:/cart";
        }
        session.removeAttribute("cart");
        redirectAttributes.addFlashAttribute("message", "Thanh toán thành công!");
        return "redirect:/products";
    }
}
