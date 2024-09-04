package com.laptop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class OrderItemID implements Serializable {

    private Order order;
    private Product product;
}
