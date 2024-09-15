package com.laptop.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/dashboard/auth/logout")
public class AdminLogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }
        resp.sendRedirect("/ecommerce/dashboard/auth/login.jsp");
    }
}
