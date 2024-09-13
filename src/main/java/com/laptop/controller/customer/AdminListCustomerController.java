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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dashboard/customers")
public class AdminListCustomerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        int page = 1, size = 10;
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if(req.getParameter("size") != null) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        List<Customer> customers = customerService.findAll(page, size);
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer customer:customers){
            customerDTOS.add(new CustomerDTO(customer));
        }
        Long count = customerService.countAll();
        req.setAttribute("customers", customerDTOS);
        req.setAttribute("totalPages",(count + size - 1)/size);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/dashboard/list-customer.jsp").forward(req, resp);

    }
}
