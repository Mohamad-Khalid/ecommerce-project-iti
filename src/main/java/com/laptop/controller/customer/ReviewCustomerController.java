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

@WebServlet(urlPatterns = "/dashboard/customer")
public class ReviewCustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        try {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Customer customer =
                    customerService.findById(id);
            CustomerDTO customerDTO = new CustomerDTO();
            customerDTO.setEmail(customer.getEmail());
            customerDTO.setFirstName(customer.getFirstName());
            customerDTO.setLastName(customer.getLastName());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setId(customer.getId());
            customerDTO.setPhone(customer.getPhone());

            req.setAttribute("customer", customerDTO);
            req.getRequestDispatcher("customerProfile.jsp").forward(req, resp);
            return;
        } catch (Exception e) {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }


    }
}
