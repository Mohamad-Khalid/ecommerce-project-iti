package com.laptop.controller.customer;

import com.laptop.dto.CustomerDTO;
import com.laptop.dto.UpdatePasswordRequest;
import com.laptop.entity.Customer;
import com.laptop.service.AuthService;
import com.laptop.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/web/update-password")
public class CustomerUpdatePasswordController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthService authService = new AuthService();
        CustomerService customerService = new CustomerService();

        UpdatePasswordRequest body = new UpdatePasswordRequest();
        body.setPassword(req.getParameter("password"));
        Customer customer =
                customerService.findById((Integer) req.getSession().getAttribute("customer-id"));
        if(customer != null){
            try{
                CustomerDTO updated = authService.updatePassword(customer,
                        body);
                if(updated != null){
                    resp.sendRedirect("/ecommerce/web/index.jsp");
                }
                else{
                    resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                }

            }
            catch (Exception e){
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }
        }
        else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }
}
