package com.laptop.dao;

import com.laptop.entity.*;
import com.laptop.dao.CustomerDAO;
import com.laptop.dao.ProductDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.HashSet;
import java.util.Set;

public class CartDAO extends GenericDAO<Cart, Integer> {
    public CartDAO() {
        super();
    }

    public Cart getCustomerCart(int costumerId){
        try {
            CustomerDAO customerDao = new CustomerDAO();
            Customer customer = customerDao.findById(costumerId);
            return  customer.getCart();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public void emptyCart(int costumerId){
        CustomerDAO customerDao = new CustomerDAO();
        Customer customer = customerDao.findById(costumerId);
        //Set<CartHasProduct> cartHasProducts = customer.getCart().getCartHasProducts();
        CartHasProductDAO cartHasProductDAO = new CartHasProductDAO();
        customer.getCart().getCartHasProducts().forEach(cartHasProductDAO::delete);
    }

    /**public void addCartProduct(int costumerId, int productId){
        Cart cart = getCustomerCart(costumerId);
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(productId);
        int cartId = cart.getId();
        CartHasProductID chpId = new CartHasProductID();
        chpId.setCartId(cartId);
        chpId.setProductId(productId);
        CartHasProduct chp = new CartHasProduct();
        chp.setCartHasProductID(chpId);
        chp.setCart(cart);
        chp.setProduct(product);
    }
    public void removeCartProduct(int costumerId, int productId){
        Cart cart = getCustomerCart(costumerId);
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(productId);
        int cartId = cart.getId();
        CartHasProductID chpId = new CartHasProductID();
        chpId.setCartId(cartId);
        chpId.setProductId(productId);
        CartHasProduct chp = new CartHasProduct();
        chp.setCartHasProductID(chpId);
        chp.setCart(cart);
        chp.setProduct(product);
    }**/


}
