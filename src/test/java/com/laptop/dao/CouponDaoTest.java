//package com.laptop.dao;
//
//import com.laptop.dto.CustomerDTO;
//import com.laptop.dto.RegistrationRequest;
//import com.laptop.entity.Cart;
//import com.laptop.entity.Coupon;
//import com.laptop.entity.Customer;
//import com.laptop.entity.Wishlist;
//import com.laptop.service.AuthService;
//import com.laptop.util.EntityManagerProvider;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//import net.bytebuddy.utility.RandomString;
//import org.hibernate.PropertyValueException;
//import org.hibernate.exception.ConstraintViolationException;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class CouponDaoTest {
//    private CouponDAO couponDAO;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
//                "test");
//        EntityManager em = emf.createEntityManager();
//        EntityManagerProvider.setEntityManager(em);
//        couponDAO = new CouponDAO();
//    }
//
//    @Test
//    void givenSavedCoupon_whenFindById_thenReturnCorrectCouponWithId() {
//        Coupon coupon = new Coupon();
//        String couponString = "adf5ad";
//        Date start = new Date();
//        Date end = java.sql.Date.valueOf(LocalDate.now().plusWeeks(1));
//
//        coupon.setCoupon(couponString);
//        coupon.setStartDate(start);
//        coupon.setEndDate(end);
//        couponDAO.save(coupon);
//
//        Coupon expectedCoupon = new Coupon();
//        expectedCoupon.setCoupon(couponString);
//        expectedCoupon.setStartDate(start);
//        expectedCoupon.setEndDate(end);
//
//        Coupon actualCoupon = couponDAO.findById(1);
//
//        assertNotNull(actualCoupon);
//        assertEquals(expectedCoupon.getCoupon(), actualCoupon.getCoupon());
//        assertEquals(expectedCoupon.getStartDate(), actualCoupon.getStartDate());
//        assertEquals(expectedCoupon.getEndDate(), actualCoupon.getEndDate());
//        assertEquals(1, actualCoupon.getId());
//
//    }
//
//    @Test
//    void whenSavingCouponWithMissingStartDate_thenThrowsException() {
//        Coupon coupon = new Coupon();
//        String couponString = "adf5ad";
//        Date end = java.sql.Date.valueOf(LocalDate.now().plusWeeks(1));
//
//        coupon.setCoupon(couponString);
//        coupon.setEndDate(end);
//
//        assertThrows(PropertyValueException.class, () -> couponDAO.save(coupon));
//    }
//
//    @Test
//    void whenSavingCouponWithMissingEndDate_thenThrowsException() {
//        Coupon coupon = new Coupon();
//        String couponString = "adf5ad";
//        Date start = new Date();
//
//        coupon.setCoupon(couponString);
//        coupon.setStartDate(start);
//
//        assertThrows(PropertyValueException.class, () -> couponDAO.save(coupon));
//    }
//
//    @Test
//    void whenSavingCouponWithMissingCouponString_thenThrowsException() {
//        Coupon coupon = new Coupon();
//        Date start = new Date();
//        Date end = java.sql.Date.valueOf(LocalDate.now().plusWeeks(1));
//
//        coupon.setStartDate(start);
//        coupon.setEndDate(end);
//
//        assertThrows(PropertyValueException.class, () -> couponDAO.save(coupon));
//    }
//
//    @Test
//    void whenSavingMultipleCouponsWithSameString_thenThrowException() {
//        Coupon[] coupons = {new Coupon(), new Coupon()};
//        String couponString = RandomString.make(5);
//        for (Coupon coupon : coupons) {
//            coupon.setCoupon(couponString);
//            coupon.setStartDate(java.sql.Date.valueOf(LocalDate.now()));
//            coupon.setEndDate(java.sql.Date.valueOf(LocalDate.now().plusWeeks(1)));
//        }
//        couponDAO.save(coupons[0]);
//        assertThrows(ConstraintViolationException.class, () -> couponDAO.save(coupons[1]));
//    }
//
//    @Test
//    void givenNoCoupons_whenFindAll_thenReturnEmptyList() {
//        List<Coupon> coupons = couponDAO.findAll(1, 10);
//        assertEquals(0, coupons.size());
//    }
//
//    @Test
//    void givenThreeCoupons_whenFindAll_thenReturnThreeCoupons() {
//
//        for (int i = 0; i < 3; i++) {
//            Coupon coupon = new Coupon();
//            String couponString = RandomString.make(5);
//            Date start = new Date();
//            Date end = java.sql.Date.valueOf(LocalDate.now().plusWeeks(1));
//
//            coupon.setCoupon(couponString);
//            coupon.setStartDate(start);
//            coupon.setEndDate(end);
//            couponDAO.save(coupon);
//        }
//        List<Coupon> couponList = couponDAO.findAll(1, 10);
//        assertEquals(3, couponList.size());
//    }
//
//    @Test
//    void givenCoupon_whenDeleteAndFindById_thenReturnNull() {
//        Coupon coupon = new Coupon();
//        String couponString = RandomString.make(5);
//        Date start = new Date();
//        Date end = java.sql.Date.valueOf(LocalDate.now().plusWeeks(1));
//
//        coupon.setCoupon(couponString);
//        coupon.setStartDate(start);
//        coupon.setEndDate(end);
//        couponDAO.save(coupon);
//
//        assertNotNull(couponDAO.findById(1));
//
//        couponDAO.delete(couponDAO.findById(1));
//        assertNull(couponDAO.findById(1));
//    }
//}