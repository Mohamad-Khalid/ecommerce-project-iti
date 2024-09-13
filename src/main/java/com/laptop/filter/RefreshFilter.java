package com.laptop.filter;

import com.laptop.entity.Customer;
import com.laptop.util.TokenHandler;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "refreshFilter")
public class RefreshFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        HttpSession httpSession = httpRequest.getSession(false);

        if (httpSession == null) {
            Cookie[] cookies = httpRequest.getCookies();
            String tokenString = TokenHandler.getTokenStringFromCookies(cookies);
            Customer customer = (Customer) TokenHandler.getUser(tokenString,
                    "CUSTOMER");
            if (customer != null) {
                httpSession = httpRequest.getSession(true);
                httpRequest.getSession().setAttribute("customer-id",
                        customer.getId());
            }

        }

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpSession != null) {
                String redirect = request.getParameter("redirect");
                httpResponse.sendRedirect(redirect == null ? "/ecommerce/web" +
                        "/index.jsp" : redirect);
        }
        else {
                chain.doFilter(request, response);
                return;
        }

    }
}
