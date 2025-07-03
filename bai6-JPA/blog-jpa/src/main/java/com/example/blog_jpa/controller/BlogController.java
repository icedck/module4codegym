package com.example.blog_jpa.controller;

import com.example.blog_jpa.model.Blog;
import com.example.blog_jpa.repository.CategoryRepository;
import com.example.blog_jpa.service.BlogService;
import com.example.blog_jpa.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("")
    public String index(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "desc") String sort, Model model) {
        Sort sortOption = sort.equals("asc") ? Sort.by("createdAt").ascending() : Sort.by("createdAt").descending();
        Page<Blog> blogs = blogService.findAll(PageRequest.of(page, 5, sortOption));
        System.out.println("Blogs: " + blogs.getContent());
        model.addAttribute("blogs", blogs);
        model.addAttribute("sort", sort);
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView user() {
        return new ModelAndView("login");
    }

    @GetMapping("/search")
    public String search(@RequestParam String keyword, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "desc") String sort, Model model) {
        Sort sortOption = sort.equals("asc") ? Sort.by("createdAt").ascending() : Sort.by("createdAt").descending();
        Page<Blog> blogs = blogService.searchByTitle(keyword, PageRequest.of(page, 5, sortOption));
        model.addAttribute("blogs", blogs);
        model.addAttribute("sort", sort);
        model.addAttribute("keyword", keyword);
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/category/{id}")
    public String viewByCategory(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "desc") String sort, Model model) {

        Sort sortOption = sort.equals("asc") ? Sort.by("createdAt").ascending() : Sort.by("createdAt").descending();

        Page<Blog> blogs = blogService.findAllByCategory_Id(id, PageRequest.of(page, 5, sortOption));

        model.addAttribute("blogs", blogs);
        model.addAttribute("categoryId", id);
        model.addAttribute("sort", sort);
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", categoryRepository.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categories", categoryRepository.findAll());
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/blogs";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "view";
    }
}
