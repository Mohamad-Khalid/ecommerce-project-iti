package com.laptop.dto.payment;

import com.laptop.entity.Customer;
import com.laptop.entity.Order;
import io.github.cdimascio.dotenv.Dotenv;
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
        this.billing_data = new BillingDataDTO(customer, order);
        this.amount = order.getTotalPrice();
        this.currency = "EGP";
        this.expiration = 60*15;
        this.payment_methods.add(4719614);
        Dotenv dotenv = Dotenv.load();
        this.notification_url = dotenv.get("TRANSACTION_PROCESSED_CALLBACK");
    }

}
