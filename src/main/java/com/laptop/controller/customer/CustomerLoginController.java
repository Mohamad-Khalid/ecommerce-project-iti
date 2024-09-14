package com.laptop.controller.customer;

import com.laptop.dto.AuthRequest;
import com.laptop.entity.Customer;
import com.laptop.service.AuthService;
import com.laptop.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(urlPatterns = "/web/auth/login")
public class CustomerLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(req.getParameter("email").toLowerCase());
        authRequest.setPassword(req.getParameter("password"));

        AuthService authService = new AuthService();
        if(req.getParameter("rememberMe") != null && req.getParameter(
                "rememberMe").equals("on")) {
            String token = authService.loginWithToken(authRequest);
            if(token != null) {
                CustomerService customerService = new CustomerService();
                Customer customer = customerService.findByEmail(authRequest.getEmail());
                if(req.getSession(false)!=null){
                    req.getSession(false).invalidate();
                }
                HttpSession session = req.getSession(true);
                session.setAttribute("customer-id", customer.getId());
                Cookie cookie = new Cookie("token", token);
                resp.addCookie(cookie);
                resp.sendRedirect("/ecommerce/web/index.jsp");
                return ;
            }

        }
        else if(authService.login(authRequest)) {
            CustomerService customerService = new CustomerService();
            Customer customer = customerService.findByEmail(authRequest.getEmail());
            if(req.getSession(false)!=null){
                req.getSession(false).invalidate();
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("customer-id", customer.getId());
            resp.sendRedirect("/ecommerce/web/index.jsp");
            return ;

        }
        else{
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

        //return false credentials error

    }
}
