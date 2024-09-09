package com.laptop.controller.customer;

import com.laptop.dto.CustomerDTO;
import com.laptop.dto.ErrorResponse;
import com.laptop.dto.RegistrationRequest;
import com.laptop.entity.Customer;
import com.laptop.service.AuthService;
import com.laptop.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/web/check-email")
public class CustomerCheckEmailUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        Pattern p = Pattern.compile("^[a-z0-9]+(.[a-z0-9]+)*@[a-z0-9]+.[a-z0-9]+$");
        System.out.println(p.matcher(email).matches());
        if (!p.matcher(email).matches()) {
            out.write("false");
            return;
        }

        CustomerService customerService = new CustomerService();
        Customer customer =
                customerService.findById((Integer) req.getSession().getAttribute(
                        "customer-id"));
        if(customer.getEmail().equals(email)) {
            out.write("true");
        }
        else {
            out.write(customerService.checkEmailAvailability(email).toString());
        }
    }
}
