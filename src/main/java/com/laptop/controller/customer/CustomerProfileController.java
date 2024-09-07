package com.laptop.controller.customer;

import com.laptop.dto.CustomerDTO;
import com.laptop.entity.Customer;
import com.laptop.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/web/profile")
public class CustomerProfileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        Customer customer =
                customerService.findById((Integer) req.getSession().getAttribute("customer_id"));

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setFirstName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setId(customer.getId());
        customerDTO.setPhone(customer.getPhone());

        req.setAttribute("customer", customerDTO);
        req.getRequestDispatcher("customerProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        Customer customer =
                customerService.findById((Integer) req.getSession().getAttribute("customer_id"));
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
        customerService.update(customer);
        resp.sendRedirect("customerProfile.jsp");
    }
}
