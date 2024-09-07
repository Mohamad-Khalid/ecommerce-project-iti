package com.laptop.util;

import com.laptop.dao.CustomerDAO;
import com.laptop.entity.Customer;
import com.laptop.security.JwtService;
import com.laptop.service.AdminService;
import com.laptop.service.CustomerService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.Cookie;

public class TokenHandler {
    public static Object getUser(String tokenString, String role) {
        if (tokenString == null || role == null)
            return null;

        if(!getRole(tokenString).equals(role))
            return null;

        Integer id = getId(tokenString);
        if (id == null) return null;
        if (role.equals("CUSTOMER")) {
            CustomerService customerService = new CustomerService();
            return customerService.findById(id);
        }
        else if (role.equals("ADMIN")) {
            AdminService adminService = new AdminService();
            return adminService.findById(id);
        }
        else {
            return null;
        }

    }

    public static String getRole(String tokenString) {
        if (tokenString == null)
            return null;
        return JwtService.extractRole(tokenString);
    }

    public static Integer getId(String tokenString) {
        if (tokenString == null)
            return null;
        return JwtService.extractId(tokenString);
    }

    public static String getTokenStringFromCookies(Cookie[] cookies) {
        if (cookies == null) {
            return null;
        } else {

            String tokenString = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    tokenString = cookie.getValue();
                }
            }
            return tokenString;
        }
    }
}
