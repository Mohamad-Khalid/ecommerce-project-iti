package com.laptop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @EmbeddedId
    OrderItemID id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "current_price", nullable = false)
    private int currentPrice;

    public OrderItem() {
    }

    public OrderItem(Product product, Order order, int quantity, int currentPrice) {
        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.currentPrice = currentPrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }
}
