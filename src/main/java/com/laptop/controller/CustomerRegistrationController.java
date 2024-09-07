package com.laptop.controller;

import com.laptop.dto.CustomerDTO;
import com.laptop.dto.RegistrationRequest;
import com.laptop.service.AuthService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/auth/register")
public class CustomerRegistrationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationRequest body = new RegistrationRequest();
        body.setFirstName(req.getParameter("firstName"));
        body.setLastName(req.getParameter("lastName"));
        body.setEmail(req.getParameter("email".toLowerCase()));
        body.setPassword(req.getParameter("password"));
        body.setAddress(req.getParameter("address"));
        body.setPhone(req.getParameter("phone"));

        AuthService authService = new AuthService();
        CustomerDTO customerDTO = authService.register(body);

        if(customerDTO != null) {
            resp.sendRedirect("/ecommerce/web/login.html");
        }
        else {
            //handle exception
        }
    }
}
