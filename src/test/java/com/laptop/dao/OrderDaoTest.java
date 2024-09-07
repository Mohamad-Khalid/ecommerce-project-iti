package com.laptop.dao;

import com.laptop.entity.Order;
import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderDaoTest {
    private OrderDAO orderDAO;

    @BeforeEach
    void setUp() {
        EntityManager entityManager = Persistence.createEntityManagerFactory(
                "test").createEntityManager();
        EntityManagerProvider.setEntityManager(entityManager);
        orderDAO = new OrderDAO();
    }

    @Test
    void givenNoOrders_whenFindAll_thenReturnEmptyList() {
        List<Order> orders = orderDAO.findAll(1,10);
        assertEquals(0, orders.size());
    }

    @Test
    void givenThreeOrders_whenFindAll_thenReturnThreeOrders(){
        for(int i = 0 ;i < 3 ;i++ ){
            Order order = new Order();
            order.setTotalPrice(500000);
            order.setDate(new Date());
            orderDAO.save(order);
        }
        assertEquals(3, orderDAO.findAll(1,10).size());
    }

    @Test
    void givenOneOrder_whenFindById_thenReturnCorrectOrder() {
        Date date = new Date();
        int price = 5412040;
        Order order = new Order();

        order.setDate(date);
        order.setTotalPrice(price);
        orderDAO.save(order);

        Order result = orderDAO.findById(1);

        assertNotNull(result);
        assertEquals(date, result.getDate());
        assertEquals(price, result.getTotalPrice());
        assertEquals(1, result.getId());
    }

    @Test
    void givenOrder_whenDeleteAndFindById_thenReturnNull(){
        Date date = new Date();
        int price = 5412040;
        Order order = new Order();

        order.setDate(date);
        order.setTotalPrice(price);
        orderDAO.save(order);

        assertNotNull(orderDAO.findById(1));

        Order toDelete = new Order();
        toDelete.setId(1);
        orderDAO.delete(toDelete);

        assertNull(orderDAO.findById(1));
    }


}
