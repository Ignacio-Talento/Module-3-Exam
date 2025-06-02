package com.ironhack.module3_exam.repository;

import com.ironhack.module3_exam.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void findAll_books_bookList() {
        List<Book> bookList = bookRepository.findAll();
        System.out.println(bookList);
        assertEquals(2, bookList.size());
    }

    @Test
    public void findById_validId_correctBook() {
        Optional<Book> bookOptional = bookRepository.findById(2);
        assertTrue(bookOptional.isPresent());
        System.out.println(bookOptional.get());
        assertEquals("Harry Potter and the Sorcerer's Stone", bookOptional.get().getTitle());
    }

    @Test
    public void findById_invalidId_bookNotPresent() {
        Optional<Book> bookOptional = bookRepository.findById(999);
        assertTrue(bookOptional.isEmpty());
    }

    @Test
    public void findByTitle_validTitle_correctBook() {
        Optional<Book> bookOptional = bookRepository.findByTitle("1984");
        assertTrue(bookOptional.isPresent());
        System.out.println(bookOptional.get());
        assertEquals("1984", bookOptional.get().getTitle());
    }

    @Test
    public void findAllByAuthor_validAuthor_bookList() {
        List<Book> bookList = bookRepository.findAllByAuthorId(1L);
        System.out.println(bookList);
        assertEquals(1, bookList.size());
    }

    @Test
    public void findAllByTitleContaining_str_bookList() {
        List<Book> bookList = bookRepository.findAllByTitleContaining("H");
        System.out.println(bookList);
        assertEquals(1, bookList.size());
    }

    @Test
    public void findAllByPagesLessThan_validPages_bookList() {
        List<Book> bookList = bookRepository.findAllByPagesLessThan(400);
        System.out.println(bookList);
        assertEquals(2, bookList.size());
    }

}