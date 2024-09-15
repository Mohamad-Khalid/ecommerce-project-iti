package com.laptop.controller.cart;

import com.laptop.dto.ItemDTO;
import com.laptop.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/web/updateQuantity")
public class UpdateQuantityController extends HttpServlet {

    private CartService cartService = new CartService(); // Assume you have a cart service

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the item ID and new quantity from the request
        int itemId = Integer.parseInt(request.getParameter("id"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
        int customerId = (Integer) request.getSession().getAttribute("customer-id");
        //int customerId = 1;

        boolean updated =  cartService.setCartItemQuantity(customerId,itemId, newQuantity);
        ItemDTO updatedItem = cartService.getIteam(customerId, itemId);

        int newTotal = updatedItem.getPrice() * updatedItem.getQuantity();
        System.out.println(newTotal);

        response.setContentType("application/json");
        if(updated){
        response.getWriter().write("{\"newTotal\": \"" + newTotal + "\"}");
        }else{
            response.getWriter().write("{\"newTotal\": \"" + -1 + "\"}");
        }
    }
}

