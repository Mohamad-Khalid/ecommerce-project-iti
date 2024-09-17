package com.laptop.controller.order;

import com.laptop.entity.Order;
import com.laptop.service.OrderServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/dashboard/order")
public class ReviewOrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Order order = orderService.getOrder(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("order", order);
        req.getRequestDispatcher("review-order.jsp").forward(req, resp);
    }
}
