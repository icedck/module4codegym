package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public Book findById(Long id) {
        return em.find(Book.class, id);
    }

    public String borrowBook(Long id) {
        Book book = em.find(Book.class, id);
        if (book.getQuantity() <= 0) throw new RuntimeException("Sách đã hết");

        book.setQuantity(book.getQuantity() - 1);
        em.merge(book);

        String code = String.format("%05d", (int) (Math.random() * 100000));
        em.createNativeQuery("INSERT INTO borrow_codes(code, book_id) VALUES (?, ?)")
                .setParameter(1, code)
                .setParameter(2, id)
                .executeUpdate();
        return code;
    }

    public void returnBook(String code) {
        List<?> result = em.createNativeQuery("SELECT book_id FROM borrow_codes WHERE code = ?")
                .setParameter(1, code)
                .getResultList();

        if (result.isEmpty()) throw new RuntimeException("Mã không hợp lệ");

        Long bookId = ((Number) result.get(0)).longValue();
        Book book = em.find(Book.class, bookId);
        book.setQuantity(book.getQuantity() + 1);
        em.merge(book);

        em.createNativeQuery("DELETE FROM borrow_codes WHERE code = ?")
                .setParameter(1, code)
                .executeUpdate();
    }

}

