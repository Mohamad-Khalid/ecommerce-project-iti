package com.laptop.service;

import com.laptop.dao.CustomerDAO;
import com.laptop.dto.AuthRequest;
import com.laptop.dto.CustomerDTO;
import com.laptop.dto.RegistrationRequest;
import com.laptop.dto.UpdatePasswordRequest;
import com.laptop.entity.Cart;
import com.laptop.entity.Customer;

import com.laptop.entity.Wishlist;
import com.laptop.security.JwtService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.mindrot.jbcrypt.BCrypt;


import jakarta.persistence.EntityManager;

import java.util.Set;


public class AuthService {
    CustomerDAO customerDAO;
    public AuthService(){
        customerDAO = new CustomerDAO();
    }
    public CustomerDTO register(RegistrationRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<RegistrationRequest>> violations =
                validator.validate(request);
        ///Handle Exception
        if(!violations.isEmpty()){
            violations.forEach(violation -> System.out.println(violation.getMessage()));
            return null;
        }
        Customer customer = new Customer();
        customer.setEmail(request.getEmail());
        customer.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setActive(true);

        Customer saved = customerDAO.save(customer);
        if(saved == null){
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(saved.getId());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());
        customerDTO.setAddress(customer.getAddress());
        return customerDTO;
    }

    public CustomerDTO updatePassword(Customer customer,
                                      UpdatePasswordRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UpdatePasswordRequest>> violations =
                validator.validate(request);

        if(!violations.isEmpty()){
            violations.forEach(violation -> System.out.println(violation.getMessage()));
            return null;
        }
        customer.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        Customer saved = customerDAO.save(customer);

        if(saved == null){
            return null;
        }

        return new CustomerDTO(saved);
    }

    public String loginWithToken(AuthRequest request) {
        try {
            Customer customer = customerDAO.findCustomerByEmail(request.getEmail());

            if (BCrypt.checkpw(request.getPassword(), customer.getPassword())) {
                String token = JwtService.generate(customer.getId(),
                        "CUSTOMER");
                System.out.println(token);

                return token;
            } else
                return null;
        } catch (Exception e) {
            return null;
        }
    }
    public boolean login(AuthRequest request) {
        try {

            Customer customer = customerDAO.findCustomerByEmail(request.getEmail());
            return BCrypt.checkpw(request.getPassword(), customer.getPassword());

        } catch (Exception e) {
            return false;
        }

    }

}
