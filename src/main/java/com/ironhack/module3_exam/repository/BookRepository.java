package com.ironhack.module3_exam.repository;

import com.ironhack.module3_exam.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByTitle(String title);
    List<Book> findAllByAuthorId(Long authorId);
    List<Book> findAllByTitleContaining(String str);
    List<Book> findAllByPagesLessThan(Integer pages);
}
