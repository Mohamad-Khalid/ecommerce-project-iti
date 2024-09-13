package com.laptop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch =
            FetchType.LAZY)
    private ProductSpecs specs;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int stock;

    private String image;

    Boolean deleted = false;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<Image> images = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<CartHasProduct> cartHasProducts = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "wishlist_has_product", joinColumns = @JoinColumn(name
            = "product_id"), inverseJoinColumns = @JoinColumn(name =
            "wishlist_id"))
    private Set<Wishlist> wishlists = new HashSet<>();
    
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", image='" + image + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
