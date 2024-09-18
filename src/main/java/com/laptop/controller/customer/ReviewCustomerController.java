package com.laptop.controller.customer;

import com.google.gson.Gson;
import com.laptop.dto.CustomerDTO;
import com.laptop.entity.Customer;
import com.laptop.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/dashboard/customer")
public class ReviewCustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        CustomerService customerService = new CustomerService();
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Customer customer = customerService.findById(id);
            if(customer != null) {
                PrintWriter out = resp.getWriter();
                CustomerDTO customerDTO = new CustomerDTO(customer);
                req.setAttribute("customer",customerDTO);
                req.getRequestDispatcher("review-customer.jsp").forward(req, resp);
            }
            else{
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
