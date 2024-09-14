package com.laptop.service;

import com.laptop.dao.CartDAO;
import com.laptop.dao.CartHasProductDAO;
import com.laptop.dto.ItemDTO;
import com.laptop.entity.Cart;
import com.laptop.entity.CartHasProduct;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public boolean addCartItemWithQuantity(int customerId, int productId,int quantity){
        return cartHasProductDAO.addItemWithQuantity(customerId,productId,quantity);
    }
    public void removeCartItem(int customerId, int productId){
        cartHasProductDAO.removeItem(customerId,productId);
    }
    public boolean setCartItemQuantity(int customerId, int productId, int quantity){
        return cartHasProductDAO.setItemQuantity(customerId,productId,quantity);
    }
    public List<ItemDTO> getCartItems(int customerId){
        return cartDAO.getCartItems(customerId)
                .stream()
                .map(ItemDTO::new)
                .collect(Collectors.toList());
    }
    public void emptyCart(int customerId){
        cartDAO.emptyCart(customerId);
    }
    public ItemDTO getIteam(int customerId, int itemId){
        return new ItemDTO(cartHasProductDAO.getItem(customerId,itemId));
    }

}
