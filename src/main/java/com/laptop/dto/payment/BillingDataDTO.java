package com.laptop.dto.payment;

import com.laptop.entity.Customer;
import com.laptop.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillingDataDTO {
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;

    public BillingDataDTO(Customer customer, Order order) {
        this.first_name = customer.getFirstName();
        this.last_name = customer.getLastName();
        this.email = customer.getEmail();
        this.phone_number = String.valueOf(order.getId());
    }
}
