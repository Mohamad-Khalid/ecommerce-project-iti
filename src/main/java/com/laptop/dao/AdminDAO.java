package com.laptop.dao;

import com.laptop.entity.Admin;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AdminDAO extends GenericDAO<Admin, Integer> {
    public AdminDAO() {
        super();
    }

    public Admin findAdminByEmail(String email) {
        try {
            TypedQuery<Admin> query = em.createQuery("SELECT a FROM Admin a WHERE a.email = :email", Admin.class);
            query.setParameter("email", email);
            return query.getResultList().get(0);
        } catch (Exception e) {
            return null;
        }
    }

}
