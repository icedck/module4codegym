package com.example.blog_jpa.repository;

import com.example.blog_jpa.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByTitleContainingIgnoreCase(String keyword, Pageable pageable);

    Page<Blog> findAllByCategory_Id(Long categoryId, Pageable pageable);

    List<Blog> findAllByCategory_Id(Long id);
}
