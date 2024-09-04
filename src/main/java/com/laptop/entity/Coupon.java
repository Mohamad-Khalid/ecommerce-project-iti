package com.laptop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@NoArgsConstructor
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "coupon", nullable = false, unique = true)
    private String coupon;

    @Column(name = "limit_payment", nullable = false)
    private int limitPayment;

    @Column(name = "percentage", nullable = false)
    private int percentage;

    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @OneToMany(mappedBy = "coupon", fetch = FetchType.LAZY)
    private Set<Order> orders = new HashSet<>();

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", coupon='" + coupon + '\'' +
                ", limitPayment=" + limitPayment +
                ", percentage=" + percentage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}