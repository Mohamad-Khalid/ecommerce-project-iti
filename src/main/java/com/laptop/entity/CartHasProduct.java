package com.laptop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_has_product")
public class CartHasProduct {

    @EmbeddedId
    private CartHasProductID cartHasProductID;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private Cart cart;

    @Column(nullable = false)
    private int quantity;

    public CartHasProduct() {
    }

    public CartHasProduct(CartHasProductID cartHasProductID, Product product, Cart cart, int quantity) {
        this.cartHasProductID = cartHasProductID;
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
    }

    public CartHasProductID getCartHasProductID() {
        return cartHasProductID;
    }

    public void setCartHasProductID(CartHasProductID cartHasProductID) {
        this.cartHasProductID = cartHasProductID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
