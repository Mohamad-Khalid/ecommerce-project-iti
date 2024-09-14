package com.laptop.controller.customer;

import com.google.gson.Gson;
import com.laptop.dto.CustomerDTO;
import com.laptop.dto.ErrorResponse;
import com.laptop.entity.Customer;
import com.laptop.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet("/web/profile")
public class CustomerProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        CustomerService customerService = new CustomerService();
        Customer customer =
                customerService.findById((Integer) req.getSession().getAttribute("customer-id"));

        System.out.println(customer);
        if(customer != null) {
            PrintWriter out = resp.getWriter();
            CustomerDTO customerDTO = new CustomerDTO(customer);
            Gson gson = new Gson();
            out.write(gson.toJson(customerDTO, CustomerDTO.class));
        }
        else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        Customer customer =
                customerService.findById((Integer) req.getSession().getAttribute("customer-id"));
        if(customer != null){
            if(req.getParameter("email") != null) {
                customer.setEmail(req.getParameter("email"));
            }
            if(req.getParameter("firstName") != null) {
                customer.setFirstName(req.getParameter("firstName"));
            }
            if(req.getParameter("lastName") != null) {
                customer.setLastName(req.getParameter("lastName"));
            }
            if(req.getParameter("address") != null) {
                customer.setAddress(req.getParameter("address"));
            }
            if(req.getParameter("phone") != null) {
                customer.setPhone(req.getParameter("phone"));
            }
            if(req.getParameter("job") != null)customer.setJob(req.getParameter("job"));
            if(req.getParameter("interests") != null)customer.setInterests(req.getParameter("interests"));
            try {
                customer.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("date")));
            }
            catch (ParseException e) {
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setMessage("Failed to register");
                req.setAttribute("errorResponse", errorResponse);
                return;

            }
            try {
                customerService.update(customer);
                resp.sendRedirect("profile.html");
            }
            catch (Exception e) {
                resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
            }

        }
        else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
