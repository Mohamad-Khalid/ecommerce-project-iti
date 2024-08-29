package com.laptop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CartHasProductID implements Serializable {

    @Column(name = "product_id",nullable = false)
    private Integer productId;

    @Column(name = "cart_id",nullable = false)
    private Integer cartId;

    public CartHasProductID() {
    }

    public CartHasProductID(Integer productId, Integer cartId) {
        this.productId = productId;
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}
