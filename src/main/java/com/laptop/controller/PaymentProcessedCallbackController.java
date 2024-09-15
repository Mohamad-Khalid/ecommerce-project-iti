package com.laptop.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.laptop.dto.payment.PaymentDTO;
import com.laptop.enums.OrderState;
import com.laptop.service.OrderService;
import com.laptop.service.OrderServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/payment")
public class PaymentProcessedCallbackController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(sb.toString(), JsonObject.class);
        boolean state =
                jsonObject.getAsJsonObject("obj")
                        .getAsJsonPrimitive("success")
                        .getAsBoolean();
        Integer orderId =Integer.parseInt(jsonObject
                .getAsJsonObject("obj").getAsJsonObject(
                "payment_key_claims")
                .getAsJsonObject("billing_data")
                .getAsJsonPrimitive("phone_number").getAsString());

        OrderService orderService = new OrderServiceImpl();
        if(state) orderService.updateOrderState(orderId, OrderState.PROCESSING);
        else  orderService.updateOrderState(orderId, OrderState.CANCELLED);

    }
}
