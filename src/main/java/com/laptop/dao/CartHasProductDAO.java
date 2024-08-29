package com.laptop.dao;

import com.laptop.entity.CartHasProduct;
import com.laptop.entity.CartHasProductID;
import jakarta.persistence.EntityManager;

public class CartHasProductDAO extends GenericDAO<CartHasProduct, CartHasProductID> {
    public CartHasProductDAO(EntityManager em) {
        super(CartHasProduct.class, em);
    }
}
