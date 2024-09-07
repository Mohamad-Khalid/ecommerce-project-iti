package com.laptop.service;

import com.laptop.dao.CartDAO;
import com.laptop.dao.CouponDAO;
import com.laptop.dao.OrderDAO;
import com.laptop.dao.ProductDAO;
import com.laptop.entity.*;
import com.laptop.enums.OrderState;
import jakarta.persistence.EntityManager;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderServiceImpl implements OrderService {
    private EntityManager entityManager;
    private final OrderDAO orderDAO = new OrderDAO();
    private final ProductDAO productDAO = new ProductDAO();
    private final CouponDAO couponDAO = new CouponDAO();



    @Override
    public void addOrder(Cart cart, String coupon) {
        Set<CartHasProduct> cartHasProducts = cart.getCartHasProducts();
        Product product = null;
        boolean flag = false;
        for (CartHasProduct cartHasProduct : cartHasProducts) {
            if (cartHasProduct.getProduct().getStock() >= cartHasProduct.getQuantity()) {
                continue;
            } else {
                product = cartHasProduct.getProduct();
                flag = true;
                break;
            }
        }

        if (flag == false) {
            Set<OrderItem> orderItems = new HashSet<>();
            Order order = new Order();
            for (CartHasProduct cartHasProduct : cartHasProducts) {
                cartHasProduct.getProduct().setStock(cartHasProduct.getProduct().getStock() - cartHasProduct.getQuantity());
                OrderItem orderItem = new OrderItem();
                orderItem.setOrder(order);
                orderItem.setProduct(cartHasProduct.getProduct());
                orderItem.setQuantity(cartHasProduct.getQuantity());
                orderItem.setCurrentPrice(cartHasProduct.getProduct().getPrice());
                orderItems.add(orderItem);
                order.setTotalPrice((cartHasProduct.getProduct().getPrice()*cartHasProduct.getQuantity()) + order.getTotalPrice());
            }
            // ------------------> empty cart (call cartDAO)
            order.setOrderItems(orderItems);
            Coupon c = couponDAO.findByName(coupon);
            if (c != null) {
                int discount = Math.min((order.getTotalPrice()*(c.getPercentage()/100)), c.getLimitPayment());
                order.setTotalPrice(order.getTotalPrice() - discount);
            }
            order.setState(OrderState.PENDING);
            orderDAO.save(order);
        } else {
            System.out.println("No Enough Stock for " + product.getName());
        }
    }

    @Override
    public Order getOrder(int id) {
        Order order = orderDAO.findById(id);
        return order;
    }

    @Override
    public List<Order> getOrders(int page, int size) {
        List<Order> orders = orderDAO.findAll(page, size);
        return orders;
    }

    @Override
    public void updateOrderState(int id, OrderState state) {
        Order order = orderDAO.findById(id);
        order.setState(state);
        orderDAO.update(order);
    }

    @Override
    public List<Order> getOrdersByFilter(int page, int size, Map<String, Object> filter) {
        List<Order> orders = orderDAO.find(filter,page,size);
        return orders;
    }


}
