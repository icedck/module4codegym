package com.example.springboot_product.controller;

import com.example.springboot_product.model.Product;
import com.example.springboot_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String ShowAllProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String saveProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Product created successfully");
        return "create";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "update";
        }else {
            return "error_404";
        }
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        model.addAttribute("product", product);
        model.addAttribute("message", "Product updated successfully");
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "delete";
        }else{
            return "error_404";
        }
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Product product) {
        productService.delete(product.getId());
        return "redirect:/products";
    }
}
