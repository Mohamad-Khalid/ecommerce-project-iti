package com.laptop.controller.admin;

import com.laptop.dto.AuthRequest;
import com.laptop.dto.ErrorResponse;
import com.laptop.entity.Admin;
import com.laptop.service.AdminAuthService;
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

        AdminAuthService authService = new AdminAuthService();
        if (req.getAttribute("rememberMe") != null && req.getAttribute(
                "rememberMe").equals("on")) {
            String token = authService.loginWithToken(authRequest);
            if (token != null) {
                AdminService adminService = new AdminService();
                Admin admin = adminService.findByEmail(authRequest.getEmail());
                if(req.getSession(false)!=null){
                    req.getSession(false).invalidate();
                }
                HttpSession session = req.getSession(true);
                session.setAttribute("admin-id", admin.getId());
                Cookie cookie = new Cookie("token", token);
                cookie.setPath("/ecommerce/dashboard/");
                resp.addCookie(cookie);
                resp.sendRedirect("/ecommerce/dashboard/customers");
                return;
            }else {
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setMessage("The credentials you entered don't " +
                        "match");
                req.setAttribute("loginErrorResponse", errorResponse);
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }


        } else if (authService.login(authRequest)) {
            AdminService adminService = new AdminService();
            Admin admin = adminService.findByEmail(authRequest.getEmail());
            if(req.getSession(false)!=null){
                req.getSession(false).invalidate();
            }
            HttpSession session = req.getSession(true);
            session.setAttribute("admin-id", admin.getId());
            resp.sendRedirect("/ecommerce/dashboard/customers");
            return;

        }
        else {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("The credentials you entered don't " +
                    "match");
            req.setAttribute("loginErrorResponse", errorResponse);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
}
