package com.laptop.dao;

import com.laptop.entity.Category;
import com.laptop.entity.Coupon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class CouponDAO extends GenericDAO<Coupon, Integer> {
    public CouponDAO(EntityManager em) {
        super(em);
    }

    public Coupon findByName(String name) {
        TypedQuery<Coupon> query = em.createQuery("from Coupon c where c.coupon = :name ", Coupon.class).setParameter("name", name);
        return query.getSingleResult();
    }
}
