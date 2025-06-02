package com.ironhack.module3_exam.repository;

import com.ironhack.module3_exam.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepositoryTest {
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void findAll_categories_categoryList() {
        List<Category> categoryList = categoryRepository.findAll();
        System.out.println(categoryList);
        assertEquals(2, categoryList.size());
    }

    @Test
    public void findById_validId_correctCategory() {
        Optional<Category> categoryOptional = categoryRepository.findById(1L);
        assertTrue(categoryOptional.isPresent());
        System.out.println(categoryOptional.get());
        assertEquals("Fiction", categoryOptional.get().getName());
    }

    @Test
    public void findById_invalidId_categoryNotPresent() {
        Optional<Category> categoryOptional = categoryRepository.findById(200L);
        assertTrue(categoryOptional.isEmpty());
    }

}