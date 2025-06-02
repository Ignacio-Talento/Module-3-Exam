package com.ironhack.module3_exam.config;

import com.ironhack.module3_exam.model.Author;
import com.ironhack.module3_exam.model.Book;
import com.ironhack.module3_exam.model.Category;
import com.ironhack.module3_exam.repository.AuthorRepository;
import com.ironhack.module3_exam.repository.BookRepository;
import com.ironhack.module3_exam.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AuthorRepository authorRepo;
    private final CategoryRepository categoryRepo;
    private final BookRepository bookRepo;

    public DataSeeder(AuthorRepository authorRepo, CategoryRepository categoryRepo, BookRepository bookRepo) {
        this.authorRepo = authorRepo;
        this.categoryRepo = categoryRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepo.deleteAll();
        authorRepo.deleteAll();
        categoryRepo.deleteAll();

        Author orwell = new Author();
        orwell.setId(1L);
        orwell.setName("George Orwell");
        authorRepo.save(orwell);

        Author rowling = new Author();
        rowling.setId(2L);
        rowling.setName("J.K. Rowling");
        authorRepo.save(rowling);

        Category fiction = new Category();
        fiction.setId(1L);
        fiction.setName("Fiction");
        categoryRepo.save(fiction);

        Category fantasy = new Category();
        fantasy.setId(2L);
        fantasy.setName("Fantasy");
        categoryRepo.save(fantasy);

        Book book1 = new Book();
        book1.setTitle("1984");
        book1.setPages(328);
        book1.setAuthor(orwell);
        book1.setCategory(fiction);
        bookRepo.save(book1);

        Book book2 = new Book();
        book2.setTitle("Harry Potter and the Sorcerer's Stone");
        book2.setPages(309);
        book2.setAuthor(rowling);
        book2.setCategory(fantasy);
        bookRepo.save(book2);
    }
}
