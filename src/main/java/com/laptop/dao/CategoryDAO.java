package com.laptop.dao;

import com.laptop.entity.Category;
import jakarta.persistence.EntityManager;

public class CategoryDAO extends GenericDAO<Category, Integer> {
    public CategoryDAO(EntityManager em) {
        super(Category.class, em);
    }
}
