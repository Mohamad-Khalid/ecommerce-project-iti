package com.laptop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "product_specs")
@Getter
@Setter
@NoArgsConstructor
public class ProductSpecs {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String processor;
    private int memory;
    private String storage;

    @Column(name = "graphics_card")
    private String graphicsCard;

    @Column(name = "display_size")
    private String displaySize;

    @Column(name = "battery_life")
    private int batteryLife;

    @Column(name = "os")
    private String os;
    private double weight;
}
