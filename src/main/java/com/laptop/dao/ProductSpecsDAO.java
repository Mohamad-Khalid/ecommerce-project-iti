package com.laptop.dao;

import com.laptop.entity.ProductSpecs;
import jakarta.persistence.EntityManager;

public class ProductSpecsDAO extends GenericDAO<ProductSpecs,
        Integer> {
    ProductSpecsDAO(EntityManager entityManager) {
        super(entityManager);
    }
}
