package com.laptop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class CartHasProductID implements Serializable {

    @Column(name = "product_id",nullable = false)
    private Integer productId;

    @Column(name = "cart_id",nullable = false)
    private Integer cartId;

}
