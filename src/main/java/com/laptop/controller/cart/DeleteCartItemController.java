package com.laptop.controller.cart;

import com.laptop.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/web/deleteCartItem")
public class DeleteCartItemController extends HttpServlet {
    private CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the item ID and new quantity from the request
        int itemId = Integer.parseInt(request.getParameter("id"));
        //int newQuantity = Integer.parseInt(request.getParameter("quantity"));
        int customerId = (Integer) request.getSession().getAttribute("customer-id");
        //int customerId = 1;
        System.out.println("first");
        cartService.removeCartItem(customerId,itemId);
        System.out.println("second");
        //response.setContentType("application/json");

        //getServletContext().getRequestDispatcher("cart").forward(request,response);

        //request.getRequestDispatcher("cart").forward(request,response);
    }
}