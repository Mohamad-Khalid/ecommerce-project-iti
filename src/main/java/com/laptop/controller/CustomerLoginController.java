package com.laptop.controller;

import com.laptop.dto.AuthRequest;
import com.laptop.service.AuthService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet(urlPatterns = "/auth/login")
public class CustomerLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(req.getParameter("email").toLowerCase());
        authRequest.setPassword(req.getParameter("password"));

        AuthService authService = new AuthService();

        if(req.getAttribute("rememberMe") != null && req.getAttribute(
                "rememberMe").equals("on")) {
            String token = authService.loginWithToken(authRequest);
            if(token != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("user", authRequest.getEmail());
                Cookie cookie = new Cookie("token", token);
                resp.addCookie(cookie);
                resp.sendRedirect("/ecommerce/web/index.html");
                return ;
            }

        }
        else if(authService.login(authRequest)) {
            HttpSession session = req.getSession(true);
            resp.sendRedirect("/ecommerce/web/index.html");
            return ;

        }
        System.out.println("#####################");
        System.out.println("failed");
        //return false credentials error

    }
}
