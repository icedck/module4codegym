package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }

    public String borrow(Long id) {
        return bookRepository.borrowBook(id);
    }

    public void returnBook(String code) {
        bookRepository.returnBook(code);
    }
}