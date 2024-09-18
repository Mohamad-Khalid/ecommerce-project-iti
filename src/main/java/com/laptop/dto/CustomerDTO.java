package com.laptop.dto;


import com.laptop.entity.Customer;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CustomerDTO implements Serializable {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String phone;

    private Date dateOfBirth;

    private String job;

    private String interests;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.phone = customer.getPhone();
        this.interests = customer.getInterests();
        this.job = customer.getJob();
        this.dateOfBirth = customer.getDateOfBirth();
    }
}
