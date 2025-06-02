package com.ironhack.module3_exam.controller.interfaces;

import com.ironhack.module3_exam.model.Book;

import java.util.List;

public interface IBookController {
    List<Book> getAllBooks();
    Book getBookById(Integer id);
}
