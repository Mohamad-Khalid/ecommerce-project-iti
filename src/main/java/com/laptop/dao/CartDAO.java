package com.laptop.dao;

import com.laptop.entity.Cart;
import jakarta.persistence.EntityManager;

public class CartDAO extends GenericDAO<Cart, Integer> {
    public CartDAO() {
        super();
    }
}
