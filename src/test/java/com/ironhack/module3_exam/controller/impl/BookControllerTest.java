package com.ironhack.module3_exam.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.module3_exam.model.Author;
import com.ironhack.module3_exam.model.Book;
import com.ironhack.module3_exam.model.Category;
import com.ironhack.module3_exam.repository.AuthorRepository;
import com.ironhack.module3_exam.repository.BookRepository;
import com.ironhack.module3_exam.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BookControllerTest {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Book book;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Optional<Author> authorOptional = authorRepository.findById(1L);
        Optional<Category> categoryOptional = categoryRepository.findById(1L);
        assertTrue(authorOptional.isPresent());
        assertTrue(categoryOptional.isPresent());
        book = new Book("Animal Farm", 159, authorOptional.get(), categoryOptional.get());
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteById(3);
    }

    @Test
    void getAllBooks_validRequest_allBooks() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void saveBook_validBody_bookSaved() throws Exception {
        String body = objectMapper.writeValueAsString(book);

        mockMvc.perform(post("/api/books").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }


}