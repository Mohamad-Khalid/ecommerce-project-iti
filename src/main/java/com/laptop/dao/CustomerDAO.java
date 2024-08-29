package com.laptop.dao;
import com.laptop.entity.Customer;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class CustomerDAO extends GenericDAO<Customer, Integer> {

    public CustomerDAO(Class<Customer> entityClass) {
        super(entityClass);
    }

    public Customer findCustomerByEmail(String email) {
        try {
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
            query.setParameter("email", email);
            return  query.getResultList().get(0);
        }
        catch (NoResultException e) {
            return null;
        }
    }

    public Customer findCustomerByFirstLastName(String firstName, String lastName) {
       try {
           TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.firstName = :firstName AND c.lastName = :lastName", Customer.class);
           query.setParameter("firstName", firstName);
           query.setParameter("lastName", lastName);
           return  query.getResultList().get(0);
       }
       catch (NoResultException e) {
           return null;
       }
    }

}
