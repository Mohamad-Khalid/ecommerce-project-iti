package com.laptop.dto.payment;

import com.laptop.entity.Customer;
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
    private String address;

    public BillingDataDTO(Customer customer) {
        this.first_name = customer.getFirstName();
        this.last_name = customer.getLastName();
        this.email = customer.getEmail();
        this.phone_number = customer.getPhone();
        this.address = customer.getAddress();
    }
}
