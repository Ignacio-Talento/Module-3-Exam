package com.ironhack.module3_exam.service.interfaces;

import com.ironhack.module3_exam.model.Book;
import jakarta.validation.Valid;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(Integer id);
    List<Book> getBooksByPagesLessThan(Integer pages);

    void saveBook(Book book);

    void deleteBook(Integer id);

    void updateBook(Book book, Integer id);

    void updateBookPages(Integer pages, Integer id);
}
