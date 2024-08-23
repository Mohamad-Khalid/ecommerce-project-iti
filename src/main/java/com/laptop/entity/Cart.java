package com.laptop.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(mappedBy = "cart")
    private Set<CartHasProduct> cartHasProducts = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public Set<CartHasProduct> getCartHasProducts() {
        return cartHasProducts;
    }

    public void setCartHasProducts(Set<CartHasProduct> cartHasProducts) {
        this.cartHasProducts = cartHasProducts;
    }
}
