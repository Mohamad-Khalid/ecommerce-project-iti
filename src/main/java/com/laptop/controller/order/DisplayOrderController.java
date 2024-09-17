package com.laptop.controller.order;

import com.laptop.dto.ItemDTO;
import com.laptop.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/web/orderDetails")
public class DisplayOrderController extends HttpServlet {

    private CartService cartService = new CartService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerId = (Integer) request.getSession().getAttribute("customer-id");
        List<ItemDTO> cartItems = cartService.getCartItems(customerId);
        int totalPrice = 0;
        for (ItemDTO itemDTO : cartItems) {
            totalPrice = totalPrice + (itemDTO.getPrice()*itemDTO.getQuantity());
        }

        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("coupon", request.getParameter("coupon"));
        System.out.println(request.getParameter("coupon"));
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }
}

