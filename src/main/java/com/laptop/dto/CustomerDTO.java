package com.laptop.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

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
}
