package com.laptop.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
public class OrderItemID implements Serializable {

    @Column(name = "order_id",nullable = false)
    private Integer orderId;

    @Column(name = "product_id",nullable = false)
    private Integer productId;
}
