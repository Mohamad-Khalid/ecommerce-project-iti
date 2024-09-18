package com.laptop.dao;

import com.laptop.entity.OrderItem;
import com.laptop.entity.OrderItemID;
import jakarta.persistence.EntityManager;

public class OrderItemDAO extends GenericDAO<OrderItem, OrderItemID> {
    public OrderItemDAO() {
        super();
    }
}
