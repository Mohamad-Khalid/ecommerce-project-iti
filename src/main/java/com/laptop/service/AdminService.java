package com.laptop.service;

import com.laptop.dao.AdminDAO;
import com.laptop.dao.CustomerDAO;
import com.laptop.entity.Admin;
import com.laptop.entity.Customer;

public class AdminService {
    private final AdminDAO adminDAO;
    public AdminService() {
        adminDAO = new AdminDAO();
    }

    public Admin findById(Integer id) {
        return adminDAO.findById(id);
    }

    public Admin findByEmail(String email) {
        return adminDAO.findAdminByEmail(email);
    }

    public Admin update(Admin admin) {
        try{
            return adminDAO.update(admin);
        }
        catch(Exception e){
            return null;
        }

    }
}
