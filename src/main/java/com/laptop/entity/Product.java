package com.laptop.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
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

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<CartHasProduct> cartHasProducts = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "wishlist_has_product", joinColumns = @JoinColumn(name
            = "product_id"), inverseJoinColumns = @JoinColumn(name =
            "wishlist_id"))
    private Set<Wishlist> wishlists = new HashSet<>();

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductSpecs getSpecs() {
        return specs;
    }

    public void setSpecs(ProductSpecs specs) {
        this.specs = specs;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<CartHasProduct> getCartHasProducts() {
        return cartHasProducts;
    }

    public void setCartHasProducts(Set<CartHasProduct> cartHasProducts) {
        this.cartHasProducts = cartHasProducts;
    }

    public Set<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(Set<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

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
