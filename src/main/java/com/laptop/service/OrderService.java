package com.laptop.service;

import com.laptop.entity.Cart;
import com.laptop.entity.Customer;
import com.laptop.entity.Order;
import com.laptop.enums.OrderState;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Order addOrder(Customer customer, String coupon);
    Order getOrder(int id);
    List<Order> getOrders(int page, int size);
    Order updateOrderState(int id, OrderState state);
    List<Order> getOrdersByFilter(int page, int size, Map<String, Object> filter);
    public List<Order> getOrdersbyCustomerId(int customerId);
}
