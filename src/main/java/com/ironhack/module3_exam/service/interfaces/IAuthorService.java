package com.ironhack.module3_exam.service.interfaces;

import com.ironhack.module3_exam.model.Author;
import jakarta.validation.Valid;

import java.util.List;

public interface IAuthorService {
    List<Author> getAllAuthors();
    Author getAuthorById(Long id);

    void saveAuthor(Author author);

    void deleteAuthor(Long id);

    void updateAuthor(Author author, Long id);
}
