package com.laptop.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "redirection")
public class RedirectionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getRequestURI()
                .equals("/ecommerce/")){
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/ecommerce/web/index.jsp");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
