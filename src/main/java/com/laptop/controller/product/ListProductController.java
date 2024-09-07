package com.laptop.controller.product;

import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import com.laptop.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> filter = new HashMap<>();

        // Processor (String)
        String processor = req.getParameter("processor");
        if (processor != null) {
            filter.put("processor", processor);
        }

        // Memory (Integer)
        String memoryStr = req.getParameter("memory");
        if (memoryStr != null) {
            try {
                filter.put("memory", Integer.valueOf(memoryStr));
            } catch (NumberFormatException e) {
                // Handle invalid integer value for memory
                // Optionally log or notify invalid input
            }
        }

        // Storage (String)
        String storage = req.getParameter("storage");
        if (storage != null) {
            filter.put("storage", storage);
        }

        // Graphics Card (String)
        String graphicsCard = req.getParameter("graphicsCard");
        if (graphicsCard != null) {
            filter.put("graphicsCard", graphicsCard);
        }

        // Display Size (String)
        String displaySize = req.getParameter("displaySize");
        if (displaySize != null) {
            filter.put("displaySize", displaySize);
        }

        // Battery Life (Integer)
        String batteryLifeStr = req.getParameter("batteryLife");
        if (batteryLifeStr != null) {
            try {
                filter.put("batteryLife", Integer.valueOf(batteryLifeStr));
            } catch (NumberFormatException e) {
                // Handle invalid integer value for battery life
            }
        }

        // OS (String)
        String os = req.getParameter("os");
        if (os != null) {
            filter.put("os", os);
        }

        // Weight (Double)
        String weightStr = req.getParameter("weight");
        if (weightStr != null) {
            try {
                filter.put("weight", Double.valueOf(weightStr));
            } catch (NumberFormatException e) {
                // Handle invalid double value for weight
            }
        }

        int page;
        if(req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        else{
            page = 1;
        }

        int size;
        if(req.getParameter("size") != null) {
            size = Integer.parseInt(req.getParameter("size"));
        }
        else{
            size = 10;
        }

        ProductService productService = new ProductService();
        List<Product> products = productService.getAllProducts(filter, page,
                size);

    }
}
