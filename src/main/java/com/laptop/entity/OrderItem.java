package com.laptop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemID.class)
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    @Id
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    @Id
    private Order order;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "current_price", nullable = false)
    private int currentPrice;

}
