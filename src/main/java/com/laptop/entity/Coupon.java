package com.laptop.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "coupon")
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

    public Coupon() {
    }

    public Coupon(String coupon, int limitPayment, int percentage, Date startDate, Date endDate, Set<Order> order) {
        this.coupon = coupon;
        this.limitPayment = limitPayment;
        this.percentage = percentage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.orders = order;
    }

    public Integer getId() {
        return id;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public int getLimitPayment() {
        return limitPayment;
    }

    public void setLimitPayment(int limitPayment) {
        this.limitPayment = limitPayment;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

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