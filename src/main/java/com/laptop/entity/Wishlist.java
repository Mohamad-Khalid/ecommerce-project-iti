package com.laptop.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wishlist")
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    @JoinTable(name = "wishlist_has_product", joinColumns = @JoinColumn(name
            = "wishlist_id"),inverseJoinColumns = @JoinColumn(name =
            "product_id"))
    private Set<Product> products = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
