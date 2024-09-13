package com.laptop.dto.payment;

import com.laptop.entity.Customer;
import com.laptop.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDTO {
    private int amount;
    private String currency;
    private String notification_url;
    private int expiration;
    private List<Object> payment_methods = new ArrayList<>();
    private BillingDataDTO billing_data;
    private CustomerPaymentDTO customer;
    private ExtrasDTO extras;

    public PaymentDTO(Customer customer, Order order) {
        this.customer = new CustomerPaymentDTO(customer);
        this.extras = new ExtrasDTO(order.getId());
        this.billing_data = new BillingDataDTO(customer);
        this.amount = order.getTotalPrice();
        this.currency = "EGP";
        this.expiration = 60*15;
        this.payment_methods.add(4719614);
        this.notification_url = "https://1503-41-37-7-190.ngrok-free" +
                ".app/ecommerce/payment";
    }

}
