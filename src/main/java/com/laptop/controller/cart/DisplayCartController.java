package com.laptop.controller.cart;

import com.laptop.dto.ItemDTO;
import com.laptop.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/web/cart")
public class DisplayCartController extends HttpServlet {

    private CartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = (Integer) request.getSession().getAttribute("customer-id");
        List<ItemDTO> cartItems = cartService.getCartItems(customerId);

        request.setAttribute("cartItems", cartItems);

        request.getRequestDispatcher("cart.jsp").forward(request, response);
        //int x = (Integer) request.getSession().getAttribute("customer-id");
    }
}

