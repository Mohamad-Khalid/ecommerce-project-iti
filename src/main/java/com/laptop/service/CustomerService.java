package com.laptop.service;

import com.laptop.dao.CustomerDAO;
import com.laptop.entity.Customer;

public class CustomerService {
    private CustomerDAO customerDAO;
    public CustomerService() {
        customerDAO = new CustomerDAO();
    }
    public Boolean checkEmailAvailability(String email) {
        return findByEmail(email) == null;
    }
    public Customer findByEmail(String email) {
        return customerDAO.findCustomerByEmail(email);
    }
    public Customer findById(Integer id) {
        return customerDAO.findById(id);
    }

    public Customer update(Customer customer) {
        try{
            return customerDAO.update(customer);
        }
        catch(Exception e){
            return null;
        }

    }
}
