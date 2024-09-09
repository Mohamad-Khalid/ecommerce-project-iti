package com.laptop.controller.admin;

import com.laptop.dto.AuthRequest;
import com.laptop.entity.Admin;
import com.laptop.service.AuthService;
import com.laptop.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
@WebServlet("/dashboard/auth/login")
public class AdminLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setEmail(req.getParameter("email").toLowerCase());
        authRequest.setPassword(req.getParameter("password"));

        AuthService authService = new AuthService();
        if (req.getAttribute("rememberMe") != null && req.getAttribute(
                "rememberMe").equals("on")) {
            String token = authService.loginWithToken(authRequest);
            if (token != null) {
                AdminService adminService = new AdminService();
                Admin admin = adminService.findByEmail(authRequest.getEmail());

                HttpSession session = req.getSession(true);
                session.setAttribute("admin-id", admin.getId());
                Cookie cookie = new Cookie("token", token);
                resp.addCookie(cookie);
                resp.sendRedirect("/ecommerce/dashboard/index.jsp");
                return;
            }

        } else if (authService.login(authRequest)) {
            AdminService adminService = new AdminService();
            Admin admin = adminService.findByEmail(authRequest.getEmail());

            HttpSession session = req.getSession(true);
            session.setAttribute("admin-id", admin.getId());
            resp.sendRedirect("/ecommerce/dashboard/index.jsp");
            return;

        }
        System.out.println("#####################");
        System.out.println("failed");
        //return false credentials error
    }
}
