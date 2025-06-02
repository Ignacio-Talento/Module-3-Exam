package com.ironhack.module3_exam.service.interfaces;

import com.ironhack.module3_exam.model.Category;
import jakarta.validation.Valid;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);

    void saveCategory(Category category);

    void deleteCategory(Long id);

    void updateCategory(Category category, Long id);
}
