package com.laptop.dao;

import com.laptop.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CategoryDaoTest {

    EntityManager entityManager;
    private CategoryDAO categoryDAO;

    Category c1, c2, c3, c4;

    @BeforeEach
    public void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
        categoryDAO = new CategoryDAO();

        c1 = new Category();
        c2 = new Category();
        c3 = new Category();
        c4 = new Category();

        c1.setName("Gaming");
        c2.setName("Workstation");
        c3.setName("Business");
        c4.setName("School");

        categoryDAO.save(c1);
        categoryDAO.save(c2);
        categoryDAO.save(c3);
        categoryDAO.save(c4);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void testFindById(int id) {
        Category c = categoryDAO.findById(id);
        assertNotNull(c);
    }

    @Test
    public void testFindAll() {
        List<Category> list = categoryDAO.findAll(1,4);
        assertNotNull(list);
        assertEquals(4, list.size());
        System.out.println(list);
    }

    @ParameterizedTest
    @CsvSource({"PCs",
            "TouchPad",
            "Sensors",
            "Scanners"})
    public void testSave(String name) {
        Category c = new Category();
        c.setName(name);
        categoryDAO.save(c);
        Category category = categoryDAO.findByName(name);
        assertNotNull(category);
        assertEquals(name, category.getName());
        System.out.println(category);
    }

    @ParameterizedTest
    @CsvSource({
            "3, PCs",
            "4, Tablets"
    })
    public void testUpdate(int id, String newName) {
        Category c = categoryDAO.findById(id);
        System.out.println(c);
        c.setName(newName);
        categoryDAO.update(c);
        Category category = categoryDAO.findById(id);
        assertNotNull(category);
        assertEquals(newName, category.getName());
        System.out.println(category);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void testDelete(int id) {
        Category c = categoryDAO.findById(id);
        categoryDAO.delete(c);
        Category category = categoryDAO.findById(id);
        assertEquals(null, category);
    }
}
