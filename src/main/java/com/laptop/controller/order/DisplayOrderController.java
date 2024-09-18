package com.laptop.controller.order;

import com.laptop.dto.ErrorResponse;
import com.laptop.dto.ItemDTO;
import com.laptop.service.CartService;
import com.laptop.service.CouponServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/web/orderDetails")
public class DisplayOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartService cartService = new CartService();
        CouponServiceImpl couponService = new CouponServiceImpl();
        int customerId = (Integer) request.getSession().getAttribute("customer-id");
        List<ItemDTO> cartItems = cartService.getCartItems(customerId);
        int totalPrice = 0;
        for (ItemDTO itemDTO : cartItems) {
            totalPrice = totalPrice + (itemDTO.getPrice()*itemDTO.getQuantity());
        }

        HttpSession session = request.getSession();
        String coupon = request.getParameter("coupon");
        request.setAttribute("totalPrice", totalPrice);
        request.setAttribute("cartItems", cartItems);
        request.setAttribute("coupon", request.getParameter("coupon"));
        System.out.println(coupon);
        if (coupon == "") {
            System.out.println("coupon is null");
            request.getRequestDispatcher("checkout.jsp").forward(request, response);
        } else if (!couponService.validateCoupon(coupon)){
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setMessage("Coupon not Valid");
            session.setAttribute("errorResponse", errorResponse);
            request.getRequestDispatcher("cart").include(request, response);
        }
        List<Integer> couponInfo = couponService.getCouponInfo(coupon);
        int discount = Math.min(totalPrice * couponInfo.get(0)/100, couponInfo.get(1));
        int newTotalPrice = totalPrice - discount;
        request.setAttribute("newTotalPrice", newTotalPrice);
        request.setAttribute("discount", discount);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
    }
}

