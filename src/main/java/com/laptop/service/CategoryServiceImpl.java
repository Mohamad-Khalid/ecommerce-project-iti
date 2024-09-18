package com.laptop.service;

import com.laptop.dao.CategoryDAO;
import com.laptop.dao.ProductDAO;
import com.laptop.entity.Category;
import com.laptop.entity.Product;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    public Category addCategory(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryDAO.update(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDAO.delete(category);
    }

    @Override
    public List<Category> getCategories(int page, int size) {
        List<Category> categories = categoryDAO.findAll(page, size);
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        Category c = categoryDAO.findById(id);
        return c;
    }

}
