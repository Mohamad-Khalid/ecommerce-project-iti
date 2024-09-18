package com.laptop.dao;

import com.laptop.entity.Category;
import com.laptop.entity.Coupon;
import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class CouponDAO extends GenericDAO<Coupon, Integer> {
    public CouponDAO() {
        super();
    }

    public Coupon findByName(String name) {
        try {
            TypedQuery<Coupon> query = EntityManagerProvider.getEntityManager().createQuery("from Coupon c where c.coupon = :name ", Coupon.class).setParameter("name", name);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
