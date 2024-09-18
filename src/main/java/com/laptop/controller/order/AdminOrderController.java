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

@WebServlet("/dashboard/orders")
public class AdminOrderController extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String size = req.getParameter("size");
        HttpSession session = req.getSession();

        int pageNumber = (page != null) ? Integer.parseInt(page) : 1;
        int pageSize = (size != null) ? (Integer.parseInt(size)) : 10;

        Map<String, Object> filterMap = new HashMap<>();
            if(req.getParameter("minDate") != null){
//                filterMap.put("min_date", req.getParameter("minDate"));
            }
            if(req.getParameter("maxDate") != null){
//                filterMap.put("max_date", req.getParameter("maxDate"));
            }
//            if(session.getAttribute("customer-id").toString() != null){
//                filterMap.put("customer_id", session.getAttribute("customer-id").toString());
//            }
            if (req.getParameter("minPrice") != null) {
                filterMap.put("min_price", req.getParameter("minPrice"));
            }
            if (req.getParameter("maxPrice") != null) {
                filterMap.put("max_price", req.getParameter("maxPrice"));
            }
            if (req.getParameter("state") != null) {
                filterMap.put("state", req.getParameter("state"));
            }

        List<Order> orders = orderService.getOrdersByFilter(pageNumber, pageSize, filterMap);
        Long count = orderService.countAllOrders(pageNumber, pageSize, filterMap);

        req.setAttribute("orders", orders);
        req.setAttribute("totalPages", (count+pageSize-1)/pageSize);
        req.setAttribute("page", pageNumber);

        req.getRequestDispatcher("list-orders.jsp").forward(req, resp);
    }
}
