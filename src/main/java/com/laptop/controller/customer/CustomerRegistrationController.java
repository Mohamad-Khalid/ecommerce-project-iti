package com.laptop.controller.customer;

import com.laptop.dto.CustomerDTO;
import com.laptop.dto.ErrorResponse;
import com.laptop.dto.RegistrationRequest;
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

@WebServlet(urlPatterns = "/web/auth/register")
public class CustomerRegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        String email = req.getParameter("email");
        Pattern p = Pattern.compile("^[a-z0-9]+(.[a-z0-9]+)*@[a-z0-9]+.[a-z0-9]+$");
        System.out.println(p.matcher(email).matches());
        if (!p.matcher(email).matches()) {
            out.println("false");
            return;
        }

        CustomerService customerService = new CustomerService();
        System.out.println("^^^^^^^^&&&&&");
        out.write(customerService.checkEmailAvailability(email).toString());

    }
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
            resp.sendRedirect("/ecommerce/web/auth/login.html");
        }
        else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Failed to register");
            req.getSession().setAttribute("errorResponse", errorResponse);
            resp.sendRedirect("/ecommerce/web/auth/registration.html");
        }
    }
}
