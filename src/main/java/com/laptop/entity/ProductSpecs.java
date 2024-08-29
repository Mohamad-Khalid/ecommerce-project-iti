package com.laptop.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "product_specs")
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
    public ProductSpecs() {}

    public ProductSpecs(String processor, int memory, String storage,
                        String graphicsCard, String displaySize,
                        int batteryLife, String os, double weight) {
        this.processor = processor;
        this.memory = memory;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.displaySize = displaySize;
        this.batteryLife = batteryLife;
        this.os = os;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
