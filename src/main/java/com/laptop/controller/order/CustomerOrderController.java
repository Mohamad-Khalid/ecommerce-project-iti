package com.laptop.controller.order;


import com.laptop.dto.ErrorResponse;
import com.laptop.dto.payment.PaymentDTO;
import com.laptop.entity.Customer;
import com.laptop.entity.Order;
import com.laptop.service.CustomerService;
import com.laptop.service.OrderServiceImpl;
import com.laptop.service.PaymentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/web/order")
public class CustomerOrderController extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        CustomerService customerService = new CustomerService();
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        String customerId = req.getParameter("customerId");
//        if (customerId != null && !customerId.isEmpty()) {
//            Customer customer = customerService.findById(Integer.parseInt(customerId));
//            if (customer != null) {
//                List<Order> orders = orderService.getOrdersbyCustomerId(customer.getId());
//                req.setAttribute("ordersHistory", orders);
//                req.getRequestDispatcher("orderHistory.jsp").forward(req, resp);
//            } else {
//                resp.getWriter().println("Customer not found");
//            }
//        } else {
//            resp.getWriter().println("Customer ID is required");
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerService customerService = new CustomerService();
        OrderServiceImpl orderService = new OrderServiceImpl();
        HttpSession session = req.getSession();
        String customerId = session.getAttribute("customer-id").toString();
        String coupon = req.getParameter("coupon");
        if (coupon == null) {
            coupon = "";
        }
        System.out.println(coupon);
        if (customerId != null && !customerId.isEmpty()) {
            try {
                Customer customer = customerService.findById(Integer.parseInt(customerId));
                if (customer != null) {

                    try {
                        Order order = orderService.addOrder(customer, coupon);
                        if (order != null) {
                            req.setAttribute("order", order);
                            PaymentDTO paymentDTO = new PaymentDTO(customer, order);
                            String paymentLink = PaymentService.generatePaymentLink(paymentDTO);
                            resp.sendRedirect(paymentLink);
                        } else {
                            ErrorResponse errorResponse = new ErrorResponse();
                            errorResponse.setMessage("No enough stock");
                            session.setAttribute("errorResponse", errorResponse);
                            doGet(req, resp);
                        }
                    } catch (RuntimeException e) {
                        ErrorResponse errorResponse = new ErrorResponse();
                        errorResponse.setMessage(e.getMessage());
                        session.setAttribute("errorResponse", errorResponse);
                        doGet(req, resp);
                    }
                } else {
                    resp.getWriter().write("Customer Not Found");
                }
            } catch (NumberFormatException e) {
                resp.getWriter().write(e.getMessage());
            }
        } else {
            resp.getWriter().write("Customer ID is required");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("cart").forward(req, resp);
        resp.sendRedirect("cart");
    }
}
