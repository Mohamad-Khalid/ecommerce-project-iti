package com.laptop.dao;

import com.laptop.entity.Coupon;
import jakarta.persistence.EntityManager;

public class CouponDAO extends GenericDAO<Coupon, Integer> {
    public CouponDAO(EntityManager em) {
        super(em);
    }
}
