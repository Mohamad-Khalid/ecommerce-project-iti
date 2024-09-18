package com.laptop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "wishlist")
@Getter
@Setter
@NoArgsConstructor
public class Wishlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    @JoinTable(name = "wishlist_has_product", joinColumns = @JoinColumn(name
            = "wishlist_id"),inverseJoinColumns = @JoinColumn(name =
            "product_id"))
    private Set<Product> products = new HashSet<>();
}
