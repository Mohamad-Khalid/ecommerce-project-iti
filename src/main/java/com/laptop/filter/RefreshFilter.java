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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebFilter(filterName = "refreshFilter")
public class RefreshFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        Set<String> auth = new HashSet<>(List.of("/ecommerce/web/auth/login.jsp"
                , "/ecommerce/web/auth/registration.jsp"));

        HttpServletRequest httpRequest = ((HttpServletRequest) request);
        HttpSession httpSession = httpRequest.getSession(false);

        if (httpSession == null || httpSession.getAttribute("customer-id") == null) {
            Cookie[] cookies = httpRequest.getCookies();
            String tokenString = TokenHandler.getTokenStringFromCookies(cookies);
            if(tokenString != null){
                Customer customer = (Customer) TokenHandler.getUser(tokenString,
                        "CUSTOMER");
                if (customer != null) {
                    if(httpSession != null && httpSession.getAttribute("admin" +
                            "-id") != null)
                        httpSession.invalidate();
                    httpSession = httpRequest.getSession(true);
                    httpRequest.getSession().setAttribute("customer-id",
                            customer.getId());
                }
                else{
                    Cookie cookie = new Cookie("token", "");
                    cookie.setMaxAge(0);
                    HttpServletResponse httpResponse = ((HttpServletResponse) response);
                    httpResponse.addCookie(cookie);
                    chain.doFilter(request, response);
                    return;
                }
            }

        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpSession != null && httpSession.getAttribute("customer-id") != null) {
            if(auth.contains(httpRequest.getRequestURI())){
                String redirect = request.getParameter("redirect");
                httpResponse.sendRedirect(redirect == null ? "/ecommerce/web" + "/index.jsp" : redirect);
                return;
            }

        }
        chain.doFilter(request, response);


    }
}
