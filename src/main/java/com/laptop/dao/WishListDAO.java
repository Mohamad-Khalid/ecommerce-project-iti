package com.laptop.dao;

import com.laptop.entity.Wishlist;
import jakarta.persistence.EntityManager;

public class WishListDAO extends GenericDAO<Wishlist, Integer> {
    public WishListDAO() {
        super();
    }
}
