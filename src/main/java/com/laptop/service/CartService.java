package com.laptop.service;

import com.laptop.dao.CartDAO;
import com.laptop.dao.CartHasProductDAO;
import com.laptop.entity.Cart;
import com.laptop.entity.CartHasProduct;

import java.util.Set;

public class CartService {

    CartDAO cartDAO ;
    CartHasProductDAO cartHasProductDAO ;

    public CartService(){
        cartDAO = new CartDAO();
        cartHasProductDAO = new CartHasProductDAO();
    }

    public void addCartItem(int customerId, int productId){
        cartHasProductDAO.saveItem(customerId,productId);
    }
    public void removeCartItem(int customerId, int productId){
        cartHasProductDAO.removeItem(customerId,productId);
    }
    public void setCartItemQuantity(int customerId, int productId, int quantity){
        cartHasProductDAO.setItemQuantity(customerId,productId,quantity);
    }
    public Set<CartHasProduct> getCartItems(int customerId){
        return cartDAO.getCartItems(customerId);
    }
    public void emptyCart(int customerId){
        cartDAO.emptyCart(customerId);
    }

}
