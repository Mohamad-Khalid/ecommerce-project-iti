package com.laptop.service;

import com.laptop.entity.Category;
import com.laptop.entity.Product;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    Category updateCategory(Category category);
    void deleteCategory(Category category);
    List<Category> getCategories(int page, int size);
    Category getCategoryById(int id);


}
