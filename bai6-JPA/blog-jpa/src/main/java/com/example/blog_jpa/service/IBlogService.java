package com.example.blog_jpa.service;

import com.example.blog_jpa.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    public List<Blog> findAll();

    public Blog findById(Long id);

    public void save(Blog blog);

    public void update(Long id,Blog blog);

    public void delete(Long id);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> searchByTitle(String keyword, Pageable pageable);

    Page<Blog> findAllByCategory_Id(Long categoryId, Pageable pageable);
}
