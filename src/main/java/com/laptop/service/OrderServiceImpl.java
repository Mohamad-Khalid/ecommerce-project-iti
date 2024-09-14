package com.laptop.service;

import com.laptop.dao.CouponDAO;
import com.laptop.dao.OrderDAO;
import com.laptop.dao.OrderItemDAO;
import com.laptop.entity.*;
import com.laptop.enums.OrderState;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO = new OrderDAO();
    private final CouponDAO couponDAO = new CouponDAO();

    @Override
    public synchronized Order addOrder(Customer customer, String coupon) {
        Set<CartHasProduct> cartHasProducts = customer.getCart().getCartHasProducts();
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
            order.setCustomer(customer);
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
            CartService cartService = new CartService();
            cartService.emptyCart(customer.getId());
            if (!coupon.isEmpty()) {
                Coupon c = couponDAO.findByName(coupon);
                if (c != null) {
                    if(c.getEndDate().before(new Date())) {
                        System.out.println("Coupon is Expired");
                        return null;
                    }
                    order.setCoupon(c);
                    int discount = Math.min(order.getTotalPrice()*c.getPercentage()/100, c.getLimitPayment());
                    order.setTotalPrice(order.getTotalPrice() - discount);
                } else {
                    System.out.println("Coupon not found");
                    return null;
                }
            }
            order.setState(OrderState.PENDING);
            return orderDAO.saveOrder(order, orderItems);
        } else {
            System.out.println("No Enough Stock for " + product.getName());
            return null;
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
    public Order updateOrderState(int id, OrderState state) {
        Order order = orderDAO.findById(id);
        order.setState(state);
        return orderDAO.update(order);
    }

    @Override
    public List<Order> getOrdersByFilter(int page, int size, Map<String, Object> filter) {
        List<Order> orders = orderDAO.find(filter,page,size);
        return orders;
    }

    public List<Order> getOrdersbyCustomerId(int customerId) {
        CustomerService customerService = new CustomerService();
        Customer customer = customerService.findById(customerId);
        List<Order> orders = customer.getOrders().stream().toList();
        return orders;

    }

    public void deleteOrder(int id) {
        Order order = orderDAO.findById(id);
        orderDAO.delete(order);
    }


}
