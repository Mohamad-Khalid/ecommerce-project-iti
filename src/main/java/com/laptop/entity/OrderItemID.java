package com.laptop.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;

@Embeddable
public class OrderItemID implements Serializable {

    @Column(name = "order_id",nullable = false)
    private Integer orderId;

    @Column(name = "product_id",nullable = false)
    private Integer productId;

    public OrderItemID() {
    }

    public OrderItemID(Integer orderId, Integer productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
