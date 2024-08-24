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
    private String name;
    private int price;
    @OneToOne(cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
    private ProductDescription description;
    private int stock;
    private String image;
    @Column(name = "barnd_name")
    private String brandName;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>();
    @OneToMany(mappedBy = "product")
    private Set<CartHasProduct> cartHasProducts = new HashSet<>();
    @ManyToMany
    @JoinTable(name = "wishlist_has_product", joinColumns = @JoinColumn(name
            = "wishlist_id"),inverseJoinColumns = @JoinColumn(name =
            "product_id"))
    private Set<Wishlist> wishlists = new HashSet<>();

    public Product() {}

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

    public ProductDescription getDescription() {
        return description;
    }

    public void setDescription(ProductDescription description) {
        this.description = description;
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

    public Set<OrderItem> getOrderItem() {
        return orderItems;
    }

    public void setOrderItem(Set<OrderItem> orderItem) {
        this.orderItems = orderItem;
    }

    public Set<CartHasProduct> getCartHasProduct() {
        return cartHasProducts;
    }

    public void setCartHasProduct(Set<CartHasProduct> cartHasProduct) {
        this.cartHasProducts = cartHasProduct;
    }

    public Set<Wishlist> getWishlist() {
        return wishlists;
    }

    public void setWishlist(Set<Wishlist> wishlist) {
        this.wishlists = wishlist;
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
