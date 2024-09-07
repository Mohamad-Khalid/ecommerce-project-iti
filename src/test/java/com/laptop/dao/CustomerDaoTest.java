package com.laptop.dao;

import com.laptop.entity.Cart;
import com.laptop.entity.Customer;
import com.laptop.entity.Wishlist;
import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerDaoTest {
    EntityManager entityManager;
    CustomerDAO customerDAO;

    Customer c1, c2, c3, c4;
    Cart cart1, cart2, cart3, cart4;
    Wishlist wishlist1, wishlist2, wishlist3, wishlist4;

    @BeforeEach
    public void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
        EntityManagerProvider.setEntityManager(entityManager);
        customerDAO = new CustomerDAO();

        c1 = new Customer();
        c2 = new Customer();
        c3 = new Customer();
        c4 = new Customer();

        cart1 = new Cart();
        cart2 = new Cart();
        cart3 = new Cart();
        cart4 = new Cart();

        wishlist1 = new Wishlist();
        wishlist2 = new Wishlist();
        wishlist3 = new Wishlist();
        wishlist4 = new Wishlist();

        c1.setFirstName("John");
        c1.setLastName("Doe");
        c1.setEmail("johndoe@example.com");
        c1.setPassword("password123");
        c1.setAddress("123 Main St");
        c1.setPhone("555-1234");
        c1.setActive(true);
        c1.setCart(cart1);
        c1.setWishlist(wishlist1);

        c2.setFirstName("Jane");
        c2.setLastName("Smith");
        c2.setEmail("janesmith@example.com");
        c2.setPassword("password456");
        c2.setAddress("456 Elm St");
        c2.setPhone("555-5678");
        c2.setActive(true);
        c2.setCart(cart2);
        c2.setWishlist(wishlist2);

        c3.setFirstName("Ali");
        c3.setLastName("Ahmed");
        c3.setEmail("aliahmed@example.com");
        c3.setPassword("password789");
        c3.setAddress("123 Cairo St");
        c3.setPhone("555-9101");
        c3.setActive(false);
        c3.setCart(cart3);
        c3.setWishlist(wishlist3);

        c4.setFirstName("Laila");
        c4.setLastName("Hassan");
        c4.setEmail("lailahassan@example.com");
        c4.setPassword("password1011");
        c4.setAddress("456 New Cairo St");
        c4.setPhone("555-1121");
        c4.setActive(false);
        c4.setCart(cart4);
        c4.setWishlist(wishlist4);

        entityManager.getTransaction().begin();
        entityManager.persist(cart1);
        entityManager.persist(cart2);
        entityManager.persist(cart3);
        entityManager.persist(cart4);
        entityManager.persist(wishlist1);
        entityManager.persist(wishlist2);
        entityManager.persist(wishlist3);
        entityManager.persist(wishlist4);
        entityManager.getTransaction().commit();

        customerDAO.save(c1);
        customerDAO.save(c2);
        customerDAO.save(c3);
        customerDAO.save(c4);
    }

    @Test
    public void testFindById() {
        Customer customer = customerDAO.findById(3);
        assertNotNull(customer);
        assertEquals(c3.getFirstName(), customer.getFirstName());
        assertEquals(c3.getLastName(), customer.getLastName());
        assertEquals(c3.getEmail(), customer.getEmail());
        assertEquals(c3.getPassword(), customer.getPassword());
        assertEquals(c3.getAddress(), customer.getAddress());
        assertEquals(c3.getPhone(), customer.getPhone());
        assertEquals(c3.isActive(), customer.isActive());
        assertEquals(c3.getCart(), customer.getCart());
        assertEquals(c3.getWishlist(), customer.getWishlist());
        System.out.println(customer);
        System.out.println(c3);
    }

    @Test
    public void testFindAll() {
        List<Customer> customers = customerDAO.findAll(1,4);
        assertNotNull(customers);
        assertEquals(4, customers.size());
    }

    @Test
    public void testSave() {
        Customer c = new Customer();
        Cart cart = new Cart();
        Wishlist wishlist = new Wishlist();
        c.setFirstName("Fatma");
        c.setLastName("Amr");
        c.setEmail("fatmaamr@example.com");
        c.setPassword("fish");
        c.setAddress("123 Main St");
        c.setPhone("222-333");
        c.setActive(true);
        c.setCart(cart);
        c.setWishlist(wishlist);
        entityManager.getTransaction().begin();
        entityManager.persist(cart);
        entityManager.persist(wishlist);
        entityManager.getTransaction().commit();
        customerDAO.save(c);

        Customer customer = customerDAO.findById(5);
        assertNotNull(customer);
        assertEquals(c.getFirstName(), customer.getFirstName());
        assertEquals(c.getLastName(), customer.getLastName());
        assertEquals(c.getEmail(), customer.getEmail());
        assertEquals(c.getPassword(), customer.getPassword());
        assertEquals(c.getAddress(), customer.getAddress());
        assertEquals(c.getPhone(), customer.getPhone());
        assertEquals(c.isActive(), customer.isActive());
        assertEquals(c.getCart(), customer.getCart());
        assertEquals(c.getWishlist(), customer.getWishlist());
        System.out.println(customer);
        System.out.println(c);

    }

    @Test
    public void testUpdate() {
        Customer c = customerDAO.findById(1);
        c.setFirstName("Nour");
        c.setLastName("Samir");
        c.setEmail("noursamir@example.com");

        customerDAO.update(c);
        Customer customer = customerDAO.findById(1);
        assertNotNull(customer);
        assertEquals(c.getFirstName(), customer.getFirstName());
        assertEquals(c.getLastName(), customer.getLastName());
        assertEquals(c.getEmail(), customer.getEmail());
        assertEquals(c.getPassword(), customer.getPassword());
        assertEquals(c.getAddress(), customer.getAddress());
        assertEquals(c.getPhone(), customer.getPhone());
        assertEquals(c.isActive(), customer.isActive());
        assertEquals(c.getCart(), customer.getCart());
        assertEquals(c.getWishlist(), customer.getWishlist());
    }

    @Test
    public void testDelete() {
        Customer c = customerDAO.findById(3);
        customerDAO.delete(c);
        assertEquals(null, customerDAO.findById(3));
    }

    @Test
    public void testFindCustomerByEmail() {
        Customer c = customerDAO.findCustomerByEmail("lailahassan@example.com");
        assertNotNull(c);
        assertEquals(c4.getFirstName(), c.getFirstName());
        assertEquals(c4.getLastName(), c.getLastName());
        assertEquals(c4.getEmail(), c.getEmail());
        assertEquals(c4.getPassword(), c.getPassword());
        assertEquals(c4.getAddress(), c.getAddress());
        assertEquals(c4.getPhone(), c.getPhone());
        System.out.println(c);
    }

    @Test
    public void testFindCustomerByPhone() {
        Customer c = customerDAO.findCustomerByPhone("555-9101");
        assertNotNull(c);
        assertEquals(c3.getFirstName(), c.getFirstName());
        assertEquals(c3.getLastName(), c.getLastName());
        assertEquals(c3.getEmail(), c.getEmail());
        assertEquals(c3.getPassword(), c.getPassword());
        assertEquals(c3.getAddress(), c.getAddress());
        assertEquals(c3.getPhone(), c.getPhone());
        System.out.println(c);
    }

    @Test
    public void testFindCustomerByFirstLastName() {
        List<Customer> c = customerDAO.findCustomersByFirstLastName("Ali", "Ahmed");
        assertNotNull(c);
        assertEquals(1, c.size());
        System.out.println(c);

    }


}
