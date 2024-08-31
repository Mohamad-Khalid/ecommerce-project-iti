package com.laptop.dao;

import com.laptop.entity.Category;
import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductDaoTest {
    EntityManager entityManager;
    private ProductDAO productDAO;

    Product p1 = new Product();
    Product p2 = new Product();
    Product p3 = new Product();
    Product p4 = new Product();
    Product p5 = new Product();

    ProductSpecs specs1 = new ProductSpecs();
    ProductSpecs specs2 = new ProductSpecs();
    ProductSpecs specs3 = new ProductSpecs();
    ProductSpecs specs4 = new ProductSpecs();
    ProductSpecs specs5 = new ProductSpecs();

    Category c1 = new Category();
    Category c2 = new Category();
    Category c3 = new Category();

    @BeforeEach
    public void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
        productDAO = new ProductDAO(entityManager);
    }

    @BeforeEach
    public void setUpTestData() {
        p1.setName("Dell XPS 13");
        p1.setPrice(1299);
        p1.setDescription("A sleek and powerful ultrabook for professionals.");
        p1.setStock(20);
        p1.setImage("dell_xps_13.jpg");
        p1.setBrandName("Dell");

        p2.setName("Apple MacBook Pro 14");
        p2.setPrice(1999);
        p2.setDescription("A high-performance laptop for creative professionals.");
        p2.setStock(15);
        p2.setImage("macbook_pro_14.jpg");
        p2.setBrandName("Apple");

        p3.setName("Lenovo IdeaPad Gaming 3");
        p3.setPrice(899);
        p3.setDescription("A budget-friendly gaming laptop with impressive performance.");
        p3.setStock(30);
        p3.setImage("lenovo_ideapad_gaming_3.jpg");
        p3.setBrandName("Lenovo");


        p4.setName("Apple MacBook Air M2");
        p4.setPrice(1299);
        p4.setDescription("A lightweight and efficient laptop for everyday tasks.");
        p4.setStock(25);
        p4.setImage("macbook_air_m2.jpg");
        p4.setBrandName("Apple");

        p5.setName("Apple MacBook Pro 16");
        p5.setPrice(2499);
        p5.setDescription("A powerful laptop for demanding tasks like video editing and gaming.");
        p5.setStock(10);
        p5.setImage("macbook_pro_16.jpg");
        p5.setBrandName("Apple");


        specs1.setProcessor("Intel Core i7-12700H");
        specs1.setMemory(16);
        specs1.setStorage("512GB SSD");
        specs1.setGraphicsCard("NVIDIA GeForce RTX 3050 Ti");
        specs1.setDisplaySize("14\" FHD (1920x1080)");
        specs1.setBatteryLife(8);
        specs1.setOs("Windows 11 Home");
        specs1.setWeight(1.7);
        p1.setSpecs(specs1);

        specs2.setProcessor("Apple M1 Pro");
        specs2.setMemory(16);
        specs2.setStorage("1TB SSD");
        specs2.setGraphicsCard("Integrated GPU");
        specs2.setDisplaySize("14.2\" Liquid Retina XDR (3024x1964)");
        specs2.setBatteryLife(17);
        specs2.setOs("macOS Monterey");
        specs2.setWeight(1.6);
        p2.setSpecs(specs2);

        specs3.setProcessor("AMD Ryzen 7 5800H");
        specs3.setMemory(8);
        specs3.setStorage("256GB SSD");
        specs3.setGraphicsCard("NVIDIA GeForce GTX 1650");
        specs3.setDisplaySize("15.6\" FHD (1920x1080)");
        specs3.setBatteryLife(5);
        specs3.setOs("Windows 11 Home");
        specs3.setWeight(2.2);
        p3.setSpecs(specs3);

        specs4.setProcessor("Apple M2");
        specs4.setMemory(8);
        specs4.setStorage("256GB SSD");
        specs4.setGraphicsCard("Integrated GPU");
        specs4.setDisplaySize("13.6\" Liquid Retina (2560x1664)");
        specs4.setBatteryLife(15);
        specs4.setOs("macOS Ventura");
        specs4.setWeight(1.2);
        p4.setSpecs(specs4);

        specs5.setProcessor("Apple M1 Max");
        specs5.setMemory(32);
        specs5.setStorage("2TB SSD");
        specs5.setGraphicsCard("Integrated GPU");
        specs5.setDisplaySize("16\" Liquid Retina XDR (3456x2234)");
        specs5.setBatteryLife(21);
        specs5.setOs("macOS Monterey");
        specs5.setWeight(2.1);
        p4.setSpecs(specs5);

        c1.setName("Gaming");
        p1.setCategory(c1);

        c2.setName("Workstation");
        p2.setCategory(c2);

        c3.setName("Business");
        p3.setCategory(c3);
        p4.setCategory(c3);
        p5.setCategory(c3);

        entityManager.getTransaction().begin();
        entityManager.persist(c1);
        entityManager.persist(c2);
        entityManager.persist(c3);
        entityManager.persist(specs1);
        entityManager.persist(specs2);
        entityManager.persist(specs3);
        entityManager.persist(specs4);
        entityManager.persist(specs5);
        entityManager.getTransaction().commit();

        productDAO.save(p1);
        productDAO.save(p2);
        productDAO.save(p3);
        productDAO.save(p4);
        productDAO.save(p5);
    }

    @Test
    public void testfindById(){
        Product product = productDAO.findById(2);
        assertNotNull(product);
        assertEquals(p2.getName(), product.getName());
        assertEquals(p2.getPrice(), product.getPrice());
        assertEquals(p2.getDescription(), product.getDescription());
        assertEquals(p2.getStock(), product.getStock());
        assertEquals(p2.getBrandName(), product.getBrandName());
        assertEquals(p2.getImage(), product.getImage());
        assertEquals(p2.getSpecs(), product.getSpecs());
        assertEquals(p2.getCategory(), product.getCategory());
    }

    @Test
    public void testfindAll() {
        List<Product> products = productDAO.findAll(1,3);
        assertNotNull(products);
        assertEquals(3, products.size());
    }

    @Test
    public void testsave() {
        Product product = new Product();
        product.setName("Dell Inspiron");
        product.setPrice(3000);
        product.setDescription("Laptop for professionals.");
        product.setStock(15);
        product.setImage("dell_xps_13.jpg");
        product.setBrandName("Dell");
        product.setCategory(c2);
        productDAO.save(product);
        Product p = productDAO.findById(6);

        assertNotNull(product);
        assertEquals(product.getName(), p.getName());
        assertEquals(product.getPrice(), p.getPrice());
        assertEquals(product.getDescription(), p.getDescription());
        assertEquals(product.getStock(), p.getStock());
        assertEquals(product.getBrandName(), p.getBrandName());
        assertEquals(product.getImage(), p.getImage());
        assertEquals(product.getSpecs(), p.getSpecs());
        assertEquals(product.getCategory(), p.getCategory());
    }

    @Test
    public void testupdate() {
        Product product = productDAO.findById(1);
        product.setBrandName("Lenovo");
        product.setStock(10);
        productDAO.update(product);
        Product p = productDAO.findById(1);

        assertEquals("Lenovo", p.getBrandName());
        assertEquals(10, p.getStock());
    }

    @Test
    public void testdelete() {
        Product product = productDAO.findById(3);
        productDAO.delete(product);
        assertEquals(null, productDAO.findById(3));
    }

    @Test
    public void testfindByCategory(){
        List<Product> products = productDAO.findByCategory("Business");
        assertNotNull(products);
        assertEquals(3, products.size());
    }

    // Test Find By Filter Given all specs of a specific laptop, should return only 1 product
    @Test
    public void testfindByAllFilters(){
        Map<String,Object> filter = new HashMap<>();
        filter.put("processor","Intel Core i7-12700H");
        filter.put("memory", 16);
        filter.put("storage", "512GB SSD");
        filter.put("weight", 1.7);
        filter.put("graphicsCard", "NVIDIA GeForce RTX 3050 Ti");
        filter.put("displaySize", "14\" FHD (1920x1080)");
        filter.put("batteryLife", 8);
        filter.put("os", "Windows 11 Home");

        List<Product> products = productDAO.findByFilter(filter,1,1);
        assertNotNull(products);
        assertEquals(1, products.size());
    }

    // Test Find By Filter Given 1 filter should return 2 products
    @Test
    public void testfindByFilter(){
        Map<String,Object> filter = new HashMap<>();
        filter.put("memory", 16);

        List<Product> products = productDAO.findByFilter(filter,1,2);
        assertNotNull(products);
        assertEquals(2, products.size());
    }

}
