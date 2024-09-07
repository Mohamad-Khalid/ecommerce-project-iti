package com.laptop.dao;

import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import com.laptop.util.EntityManagerProvider;
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
public class ProductSpecsDaoTest {

    EntityManager entityManager;
    ProductSpecsDAO productSpecsDao;

    ProductSpecs specs1, specs2, specs3, specs4, specs5;

    @BeforeEach
    public void setUp() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();
        EntityManagerProvider.setEntityManager(entityManager);
        productSpecsDao = new ProductSpecsDAO();

        specs1 = new ProductSpecs();
        specs2 = new ProductSpecs();
        specs3 = new ProductSpecs();
        specs4 = new ProductSpecs();
        specs5 = new ProductSpecs();

        specs1.setProcessor("Intel Core i7-12700H");
        specs1.setMemory(16);
        specs1.setStorage("512GB SSD");
        specs1.setGraphicsCard("NVIDIA GeForce RTX 3050 Ti");
        specs1.setDisplaySize("14\" FHD (1920x1080)");
        specs1.setBatteryLife(8);
        specs1.setOs("Windows 11 Home");
        specs1.setWeight(1.7);

        specs2.setProcessor("Apple M1 Pro");
        specs2.setMemory(16);
        specs2.setStorage("1TB SSD");
        specs2.setGraphicsCard("Integrated GPU");
        specs2.setDisplaySize("14.2\" Liquid Retina XDR (3024x1964)");
        specs2.setBatteryLife(17);
        specs2.setOs("macOS Monterey");
        specs2.setWeight(1.6);

        specs3.setProcessor("AMD Ryzen 7 5800H");
        specs3.setMemory(8);
        specs3.setStorage("256GB SSD");
        specs3.setGraphicsCard("NVIDIA GeForce GTX 1650");
        specs3.setDisplaySize("15.6\" FHD (1920x1080)");
        specs3.setBatteryLife(5);
        specs3.setOs("Windows 11 Home");
        specs3.setWeight(2.2);

        specs4.setProcessor("Apple M2");
        specs4.setMemory(8);
        specs4.setStorage("256GB SSD");
        specs4.setGraphicsCard("Integrated GPU");
        specs4.setDisplaySize("13.6\" Liquid Retina (2560x1664)");
        specs4.setBatteryLife(15);
        specs4.setOs("macOS Ventura");
        specs4.setWeight(1.2);

        specs5.setProcessor("Apple M1 Max");
        specs5.setMemory(32);
        specs5.setStorage("2TB SSD");
        specs5.setGraphicsCard("Integrated GPU");
        specs5.setDisplaySize("16\" Liquid Retina XDR (3456x2234)");
        specs5.setBatteryLife(21);
        specs5.setOs("macOS Monterey");
        specs5.setWeight(2.1);

        productSpecsDao.save(specs1);
        productSpecsDao.save(specs2);
        productSpecsDao.save(specs3);
        productSpecsDao.save(specs4);
        productSpecsDao.save(specs5);

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    public void testfindById(int id){
        ProductSpecs specs = productSpecsDao.findById(id);
        assertNotNull(specs);
    }

    @Test
    public void testfindAll() {
        List<ProductSpecs> productSpecs = productSpecsDao.findAll(1,5);
        assertNotNull(productSpecs);
        assertEquals(5, productSpecs.size());
    }

    @Test
    public void testsave() {
        ProductSpecs ps1 = new ProductSpecs();
        ps1.setProcessor("Intel Core i5-1135G7");
        ps1.setMemory(8);
        ps1.setStorage("512GB SSD");
        ps1.setGraphicsCard("Intel Iris Xe Graphics");
        ps1.setDisplaySize("14\" FHD (1920x1080)");
        ps1.setBatteryLife(7);
        ps1.setOs("Windows 11 Home");
        ps1.setWeight(1.5);
        productSpecsDao.save(ps1);
        ProductSpecs specs = productSpecsDao.findById(6);

        assertNotNull(specs);
        assertEquals(ps1.getProcessor(), specs.getProcessor());
        assertEquals(ps1.getMemory(), specs.getMemory());
        assertEquals(ps1.getStorage(), specs.getStorage());
        assertEquals(ps1.getGraphicsCard(), specs.getGraphicsCard());
        assertEquals(ps1.getDisplaySize(), specs.getDisplaySize());
        assertEquals(ps1.getBatteryLife(), specs.getBatteryLife());
        assertEquals(ps1.getOs(), specs.getOs());
        assertEquals(ps1.getWeight(), specs.getWeight());

    }

    @ParameterizedTest
    @CsvSource({
            "1, Intel Core i5-1135G7, 32, 512GB HDD"
    })
    public void testupdate(int id, String processor, int memory, String storage) {
        ProductSpecs specs = productSpecsDao.findById(id);
        specs.setProcessor(processor);
        specs.setMemory(memory);
        specs.setStorage(storage);
        productSpecsDao.update(specs);
        ProductSpecs specs1 = productSpecsDao.findById(id);

        assertEquals("Intel Core i5-1135G7", specs1.getProcessor());
        assertEquals(32, specs.getMemory());
        assertEquals("512GB HDD", specs1.getStorage());
    }

    @Test
    public void testdelete() {
        ProductSpecs specs = productSpecsDao.findById(3);
        productSpecsDao.delete(specs);
        assertEquals(null, productSpecsDao.findById(3));
    }

}
