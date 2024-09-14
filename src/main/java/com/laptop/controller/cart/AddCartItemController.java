package com.laptop.controller.cart;

import com.laptop.dto.ItemDTO;
import com.laptop.service.CartService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/web/addCartItem")
public class AddCartItemController extends HttpServlet{
    private CartService cartService = new CartService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the item ID and new quantity from the request
        int itemId = Integer.parseInt(request.getParameter("id"));
        int newQuantity = Integer.parseInt(request.getParameter("quantity"));
        //int customerId = (Integer) request.getSession().getAttribute("customer-id");
        int customerId = 1;

        boolean added =  cartService.addCartItemWithQuantity(customerId,itemId, newQuantity);

        response.setContentType("application/json");
        if(added){
            response.getWriter().write("{\"succeeded\": \"" + 1 + "\"}");
        }else{
            response.getWriter().write("{\"succeeded\": \"" + -1 + "\"}");
        }
    }
}
