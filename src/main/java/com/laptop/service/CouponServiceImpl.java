package com.laptop.service;

import com.laptop.dao.CouponDAO;
import com.laptop.entity.Coupon;
import com.laptop.entity.Order;

import java.util.List;

public class CouponServiceImpl implements CouponService {
    private final CouponDAO couponDAO = new CouponDAO();
    @Override
    public Coupon addCoupon(Coupon coupon) {
        return couponDAO.save(coupon);
    }

    @Override
    public void deleteCoupon(Coupon coupon) {
        couponDAO.delete(coupon);
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        return couponDAO.update(coupon);
    }

    @Override
    public Coupon findCouponById(int id) {
        Coupon c = couponDAO.findById(id);
        return c;
    }

    @Override
    public List<Coupon> findAllCoupons(int page, int size) {
        List<Coupon> coupons = couponDAO.findAll(page, size);
        return coupons;
    }

    @Override
    public Coupon findCouponByName(String name) {
        Coupon c = couponDAO.findByName(name);
        return c;
    }

    @Override
    public List<Order> getAllOrdersByCouponName(String couponName) {
        Coupon c = couponDAO.findByName(couponName);
        List<Order> orders = c.getOrders().stream().toList();
        return orders;
    }
}