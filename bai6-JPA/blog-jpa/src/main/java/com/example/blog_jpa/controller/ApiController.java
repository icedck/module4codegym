package com.example.blog_jpa.controller;

import com.example.blog_jpa.model.Blog;
import com.example.blog_jpa.model.Category;
import com.example.blog_jpa.repository.BlogRepository;
import com.example.blog_jpa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        System.out.println("GET /api/categories called"); // 🔍
        return categoryRepository.findAll();
    }

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    @GetMapping("/categories/{id}/blogs")
    public List<Blog> getBlogsByCategory(@PathVariable Long id) {
        return blogRepository.findAllByCategory_Id(id);
    }

    @GetMapping("/blogs/{id}")
    public Blog getBlogDetail(@PathVariable Long id) {
        return blogRepository.findById(id).orElse(null);
    }
}
