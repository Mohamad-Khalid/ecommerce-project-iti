package com.laptop.filter;

import com.laptop.entity.Admin;
import com.laptop.util.TokenHandler;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

@WebFilter(filterName = "adminAuthFilter")
public class AdminAuthFilter implements Filter {
    Pattern pattern = Pattern.compile("^/ecommerce/dashboard/auth/.*$");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        HttpSession httpSession = httpRequest.getSession(false);

        if (httpSession == null) {
            Cookie[] cookies = httpRequest.getCookies();
            String tokenString = TokenHandler.getTokenStringFromCookies(cookies);
            Admin admin = (Admin) TokenHandler.getUser(tokenString,
                    "ADMIN");
            if (admin != null) {
                httpSession = httpRequest.getSession(true);
                httpRequest.getSession().setAttribute("admin-id",
                        admin.getId());
            }

        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpSession != null) {
            if(pattern.matcher(httpRequest.getRequestURI()).matches()) {
                String redirect = request.getParameter("redirect");
                httpResponse.sendRedirect(redirect == null ? "/ecommerce/dashboard" +
                        "/index.html" : redirect);
                return;
            }
            else {
                chain.doFilter(request, response);
                return;
            }
        }
        else {
            if(pattern.matcher(httpRequest.getRequestURI()).matches()) {
                chain.doFilter(request, response);
                return;
            }
            else {
                httpResponse.sendRedirect("/ecommerce/dashboard/web/login" +
                        ".html" +
                        "?redirect=" + httpRequest.getRequestURI());
                return;
            }
        }

    }

}
