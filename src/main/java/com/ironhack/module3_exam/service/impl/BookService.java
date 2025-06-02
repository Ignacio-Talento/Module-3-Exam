package com.ironhack.module3_exam.service.impl;

import com.ironhack.module3_exam.model.Book;
import com.ironhack.module3_exam.repository.BookRepository;
import com.ironhack.module3_exam.service.interfaces.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book " + id + " not found");
        return bookOptional.get();
    }

    public List<Book> getBooksByPagesLessThan(Integer pages) {
        return bookRepository.findAllByPagesLessThan(pages);
    }

    @Override
    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book, Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book " + id + " not found");
        bookRepository.save(book);
    }

    @Override
    public void updateBookPages(Integer pages, Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book " + id + " not found");
        Book book = bookOptional.get();
        book.setPages(pages);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
