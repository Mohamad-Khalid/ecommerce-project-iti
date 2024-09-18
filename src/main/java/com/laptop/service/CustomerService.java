package com.laptop.service;

import com.laptop.dao.CustomerDAO;
import com.laptop.entity.Customer;

import java.util.List;

public class CustomerService {
    private CustomerDAO customerDAO;
    public CustomerService() {
        customerDAO = new CustomerDAO();
    }
    public Long countAll() {
        return customerDAO.countAll();
    }
    public List<Customer> findAll(int page, int size) {
        return customerDAO.findAll(page, size);
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
