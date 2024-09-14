package com.laptop.dao;

import com.laptop.entity.*;
import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CartHasProductDAO extends GenericDAO<CartHasProduct, CartHasProductID> {
    public CartHasProductDAO() {
        super();
    }

//    public CartHasProduct getByProduct(Product product){
//        try {
//            TypedQuery<CartHasProduct> query = em.createQuery("SELECT c FROM Carthasproduct c WHERE c.product_id = :id", CartHasProduct.class);
//            query.setParameter("id", product.getId());
//            return  query.getSingleResult();
//        }
//        catch (NoResultException e) {
//            return null;
//        }
//    }

    public CartHasProduct createCartProduct(Cart cart,Product product){
        CartHasProductID chpId = new CartHasProductID();
        chpId.setCartId(cart.getId());
        chpId.setProductId(product.getId());
        CartHasProduct chp = new CartHasProduct();
        chp.setCartHasProductID(chpId);
        chp.setCart(cart);
        chp.setProduct(product);
        chp.setQuantity(1);
        return chp;
    }

    public void saveItem(int customerId, int productId){
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        Customer customer = customerDAO.findById(customerId);
        Product product = productDAO.findById(productId);
        CartHasProduct cartHasProduct = createCartProduct(customer.getCart(),product);
        try {
            EntityManagerProvider.getEntityManager().getTransaction().begin();
            EntityManagerProvider.getEntityManager().persist(cartHasProduct);
            EntityManagerProvider.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeItem(int customerId, int productId){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.findById(customerId);
        try {
            TypedQuery<CartHasProduct> query = EntityManagerProvider.getEntityManager().createQuery(
                    "SELECT c FROM CartHasProduct c " +
                            "JOIN c.product p " +
                            "JOIN c.cart cart " +
                            "WHERE p.id = :productId AND cart.id = :cartId",
                    CartHasProduct.class);
            query.setParameter("productId", productId);
            query.setParameter("cartId", customer.getCart().getId());
            CartHasProduct cartHasProduct = query.getSingleResult();
            EntityManagerProvider.getEntityManager().getTransaction().begin();
            EntityManagerProvider.getEntityManager().remove(cartHasProduct);
            EntityManagerProvider.getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean setItemQuantity(int customerId, int productId, int quantity){
        System.out.println("arrived st dso");
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.findById(customerId);
        System.out.println("first dao operation");
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(productId);
        System.out.println("second dao operation");
        if(quantity < 1 || product.getStock() < quantity){
            return false;
        }
        try {
            System.out.println("in try");
            //TypedQuery<CartHasProduct> query = em.createQuery("SELECT c FROM CartHasProduct c WHERE c.product.getProductId() = :productId and c.cart.getCartId() = :cartId", CartHasProduct.class);
//            TypedQuery<CartHasProduct> query = em.createQuery(
//                    "SELECT c FROM CartHasProduct c " +
//                            "JOIN c.product p " +
//                            "JOIN c.cart cart " +
//                            "WHERE p.id = :productId AND cart.id = :cartId",
//                    CartHasProduct.class);
//            System.out.println("query created");
//            query.setParameter("productId", productId);
//            query.setParameter("cartId", customer.getCart().getId());
//            CartHasProduct cartHasProduct = query.getSingleResult();
            String jpql = "SELECT c FROM CartHasProduct c " +
                    "WHERE c.product.id = :productId AND c.cart.id = :cartId";
            Query query = EntityManagerProvider.getEntityManager().createQuery(jpql);
            query.setParameter("productId", productId);
            query.setParameter("cartId", customer.getCart().getId());
            CartHasProduct cartHasProduct = (CartHasProduct) query.getSingleResult();
            System.out.println("query finished");
            cartHasProduct.setQuantity(quantity);
            EntityManagerProvider.getEntityManager().getTransaction().begin();
            EntityManagerProvider.getEntityManager().merge(cartHasProduct);
            EntityManagerProvider.getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addItemWithQuantity(int customerId, int productId, int quantity){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.findById(customerId);
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(productId);
        if(quantity < 1 || product.getStock() < quantity){
            return false;
        }
        CartHasProduct cartHasProduct = createCartProduct(customer.getCart(),product);
        cartHasProduct.setQuantity(quantity);
        EntityManagerProvider.getEntityManager().getTransaction().begin();
        EntityManagerProvider.getEntityManager().persist(cartHasProduct);
        EntityManagerProvider.getEntityManager().getTransaction().commit();
        return true;
    }

    public CartHasProduct getItem(int customerId, int productId){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.findById(customerId);
        try {
            String jpql = "SELECT c FROM CartHasProduct c " +
                    "WHERE c.product.id = :productId AND c.cart.id = :cartId";
            Query query = EntityManagerProvider.getEntityManager().createQuery(jpql);
            query.setParameter("productId", productId);
            query.setParameter("cartId", customer.getCart().getId());
            CartHasProduct cartHasProduct = (CartHasProduct) query.getSingleResult();
            return cartHasProduct;
//            TypedQuery<CartHasProduct> query = em.createQuery(
//                    "SELECT c FROM CartHasProduct c " +
//                            "JOIN c.product p " +
//                            "JOIN c.cart cart " +
//                            "WHERE p.id = :productId AND cart.id = :cartId",
//                    CartHasProduct.class);
//            query.setParameter("productId", productId);
//            query.setParameter("cartId", customer.getCart().getId());
//            return query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
