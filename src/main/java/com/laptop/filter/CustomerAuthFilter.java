package com.laptop.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import com.laptop.entity.Customer;
import com.laptop.util.TokenHandler;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "customerAuthFilter")
public class CustomerAuthFilter implements Filter {
    Pattern pattern = Pattern.compile("^/ecommerce/web/auth/.*$");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {
        System.out.println("CustomerAuthFilter");
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

        if (httpSession != null && httpSession.getAttribute("customer-id") != null) {
            if(pattern.matcher(httpRequest.getRequestURI()).matches()) {
                String redirect = request.getParameter("redirect");
                httpResponse.sendRedirect(redirect == null ? "/ecommerce/web" +
                        "/index.jsp" : redirect);
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
                httpResponse.sendRedirect("/ecommerce/web/auth/login" +
                        ".html?redirect=" + httpRequest.getRequestURI());
                return;
            }
        }

    }

}
