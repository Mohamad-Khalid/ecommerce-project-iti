package com.laptop.dto;

import com.laptop.entity.ProductSpecs;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductSpecsDTO {
    private Integer id;
    private String processor;
    private int memory;
    private String storage;
    private String graphicsCard;
    private String displaySize;
    private int batteryLife;
    private String os;
    private double weight;

    public ProductSpecsDTO(ProductSpecs productSpecs){
        this.id = productSpecs.getId();
        this.processor = productSpecs.getProcessor();
        this.memory = productSpecs.getMemory();
        this.storage = productSpecs.getStorage();
        this.graphicsCard = productSpecs.getGraphicsCard();
        this.displaySize = productSpecs.getDisplaySize();
        this.batteryLife = productSpecs.getBatteryLife();
        this.os = productSpecs.getOs();
        this.weight = productSpecs.getWeight();
    }
}
