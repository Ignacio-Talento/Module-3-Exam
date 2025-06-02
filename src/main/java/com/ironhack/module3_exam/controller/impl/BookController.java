package com.ironhack.module3_exam.controller.impl;

import com.ironhack.module3_exam.controller.dto.BookPagesDTO;
import com.ironhack.module3_exam.controller.interfaces.IBookController;
import com.ironhack.module3_exam.model.Book;
import com.ironhack.module3_exam.service.interfaces.IBookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController implements IBookController {
    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/books/pages")
    public List<Book> getBooksByPagesLessThan(@RequestParam(defaultValue = "0") Integer pages) {
        return bookService.getBooksByPagesLessThan(pages);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody @Valid Book book) {
        bookService.saveBook(book);
    }

    @PutMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody @Valid Book book, @PathVariable Integer id) {
        bookService.updateBook(book, id);
    }

    @PatchMapping("/books/pages/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBookPages(@RequestBody @Valid BookPagesDTO bookPagesDTO, @PathVariable Integer id) {
        bookService.updateBookPages(bookPagesDTO.getPages(), id);
    }

    @DeleteMapping("/books/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
    }



}
