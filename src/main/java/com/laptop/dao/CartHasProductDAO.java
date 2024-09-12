package com.laptop.dao;

import com.laptop.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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
            em.getTransaction().begin();
            em.persist(cartHasProduct);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void removeItem(int customerId, int productId){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.findById(customerId);
        try {
            TypedQuery<CartHasProduct> query = em.createQuery(
                    "SELECT c FROM CartHasProduct c " +
                            "JOIN c.product p " +
                            "JOIN c.cart cart " +
                            "WHERE p.id = :productId AND cart.id = :cartId",
                    CartHasProduct.class);
            query.setParameter("productId", productId);
            query.setParameter("cartId", customer.getCart().getId());
            CartHasProduct cartHasProduct = query.getSingleResult();
            em.getTransaction().begin();
            em.remove(cartHasProduct);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setItemQuantity(int customerId, int productId, int quantity){
        CustomerDAO customerDAO = new CustomerDAO();
        Customer customer = customerDAO.findById(customerId);
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(productId);
        if(quantity < 1 || product.getStock() < quantity){
            return;
        }
        try {
            //TypedQuery<CartHasProduct> query = em.createQuery("SELECT c FROM CartHasProduct c WHERE c.product.getProductId() = :productId and c.cart.getCartId() = :cartId", CartHasProduct.class);
            TypedQuery<CartHasProduct> query = em.createQuery(
                    "SELECT c FROM CartHasProduct c " +
                            "JOIN c.product p " +
                            "JOIN c.cart cart " +
                            "WHERE p.id = :productId AND cart.id = :cartId",
                    CartHasProduct.class);
            query.setParameter("productId", productId);
            query.setParameter("cartId", customer.getCart().getId());
            CartHasProduct cartHasProduct = query.getSingleResult();
            cartHasProduct.setQuantity(quantity);
            em.getTransaction().begin();
            em.persist(cartHasProduct);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
