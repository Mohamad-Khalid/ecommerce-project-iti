package com.laptop.dao;

import com.laptop.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CategoryDAO extends GenericDAO<Category, Integer> {
    public CategoryDAO(EntityManager em) {
        super(em);
    }

    public Category findByName(String name) {
        TypedQuery<Category> query = em.createQuery("from Category c where c.name = :name ", Category.class).setParameter("name", name);
        return query.getSingleResult();
    }
}
