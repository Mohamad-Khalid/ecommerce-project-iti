package com.laptop.dao;

import com.laptop.entity.*;
import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderItemDaoTest {
//    private OrderItemDAO orderItemDAO;
//    private Product product;
//    private Category category;
//    private Order order;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
//                "test");
//        EntityManager em = emf.createEntityManager();
//        EntityManagerProvider.setEntityManager(em);
//        orderItemDAO = new OrderItemDAO();
//
//        category = new Category();
//        category.setName("Gaming");
//
//        product = new Product();
//        product.setBrandName("Dell");
//        product.setCategory(category);
//        product.setName("Dell G5");
//        product.setDescription("Dell G5");
//
//        order = new Order();
//
//        em.getTransaction().begin();
//        em.persist(category);
//        em.persist(product);
//        em.persist(order);
//        em.getTransaction().commit();
//
//    }
//
//    @Test
//    void givenProductAndOrder_whenSaveOrderItem_thenReturnCorrectOrderItem() {
//        OrderItem orderItem = new OrderItem();
//        orderItem.setProduct(product);
//        orderItem.setOrder(order);
//        orderItem.setQuantity(10);
//
//        orderItemDAO.save(orderItem);
//
//        assertNotNull(orderItem);
//        assertEquals(product.getId(),orderItem.getProduct().getId());
//        assertEquals(order.getId(),orderItem.getOrder().getId());
//        assertEquals(10,orderItem.getQuantity());
//    }
//
//    @Test
//    void givenOrderItem_whenFindById_thenReturnOrderItem(){
//        OrderItem orderItem = new OrderItem();
//        orderItem.setProduct(product);
//        orderItem.setOrder(order);
//        orderItem.setQuantity(10);
//
//        orderItemDAO.save(orderItem);
//
//        OrderItemID orderItemID = new OrderItemID();
//        orderItemID.setOrder(order);
//        orderItemID.setProduct(product);
//        OrderItem result = orderItemDAO.findById(orderItemID);
//
//        assertNotNull(result);
//        assertEquals(product.getId(),orderItem.getProduct().getId());
//        assertEquals(order.getId(),orderItem.getOrder().getId());
//        assertEquals(10,orderItem.getQuantity());
//    }
//
//    @Test
//    void whenUpdateOrderItemAndFind_thenReturnCorrectOrderItem(){
//        OrderItem[] orderItems = {new OrderItem(), new OrderItem()};
//        for(int i = 0 ;i < 2 ;i++){
//            orderItems[i].setProduct(product);
//            orderItems[i].setOrder(order);
//        }
//        orderItems[0].setQuantity(1);
//        orderItems[0].setCurrentPrice(50000);
//
//        orderItems[1].setQuantity(2);
//        orderItems[1].setCurrentPrice(60000);
//
//        orderItemDAO.save(orderItems[0]);
//        orderItemDAO.update(orderItems[1]);
//
//        OrderItemID orderItemID = new OrderItemID();
//        orderItemID.setOrder(order);
//        orderItemID.setProduct(product);
//        OrderItem result = orderItemDAO.findById(orderItemID);
//
//        assertNotNull(result);
//        assertEquals(product.getId(),result.getProduct().getId());
//        assertEquals(order.getId(),result.getOrder().getId());
//        assertEquals(2,result.getQuantity());
//        assertEquals(60000,result.getCurrentPrice());
//    }
//
//    @Test
//    void givenOrder_whenDeleteAndFindById_thenReturnNull(){
//        OrderItem orderItem = new OrderItem();
//        orderItem.setProduct(product);
//        orderItem.setOrder(order);
//        orderItem.setQuantity(10);
//
//        orderItemDAO.save(orderItem);
//
//        OrderItemID orderItemID = new OrderItemID();
//        orderItemID.setOrder(order);
//        orderItemID.setProduct(product);
//
//        assertNotNull(orderItemDAO.findById(orderItemID));
//
//        orderItemDAO.delete(orderItem);
//        assertNull(orderItemDAO.findById(orderItemID));
//    }
}
