package com.laptop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cart_has_product")
@Getter
@Setter
@NoArgsConstructor
public class CartHasProduct {

    @EmbeddedId
    private CartHasProductID cartHasProductID;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id", insertable = false, updatable = false)
    private Cart cart;

    @Column(nullable = false)
    @Min(1)
    private int quantity;
}
