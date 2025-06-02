package com.ironhack.module3_exam.repository;

import com.ironhack.module3_exam.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest {
    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void findAll_authors_authorList() {
        List<Author> authorList = authorRepository.findAll();
        System.out.println(authorList);
        assertEquals(2, authorList.size());
    }

    @Test
    public void findById_validId_correctAuthor() {
        Optional<Author> authorOptional = authorRepository.findById(1L);
        assertTrue(authorOptional.isPresent());
        System.out.println(authorOptional.get());
        assertEquals("George Orwell", authorOptional.get().getName());
    }

    @Test
    public void findById_invalidId_authorNotPresent() {
        Optional<Author> authorOptional = authorRepository.findById(10L);
        assertTrue(authorOptional.isEmpty());
    }



}