package com.laptop.controller.product;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.laptop.dto.ProductDTO;
import com.laptop.entity.Product;
import com.laptop.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/dashboard/products")
public class AdminListProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> filter = new HashMap<>();

        String category = req.getParameter("category");
        if (category != null) {
            try{
                filter.put("category", Integer.parseInt(category));
            }
            catch (NumberFormatException e){
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

        }

        String brand = req.getParameter("brand");
        if (brand != null) {
            filter.put("brand", brand);
        }

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


        String minPrice = req.getParameter("min-price");
        if (minPrice != null) {
            try {
                filter.put("min-price", Integer.valueOf(minPrice));
            } catch (NumberFormatException e) {
                // Handle invalid
            }
        }

        String maxPrice = req.getParameter("max-price");
        if (maxPrice != null) {
            try {
                filter.put("max-price", Integer.valueOf(maxPrice));
            } catch (NumberFormatException e) {
                // Handle invalid
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
        Long count = productService.countAllProducts(filter, page,
                size);

        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product:products){
            productDTOList.add(new ProductDTO(product));
        }
        req.setAttribute("totalPages",(count + size - 1)/size);
        req.setAttribute("products", productDTOList);
        req.setAttribute("page", page);
        req.getRequestDispatcher("list-product.jsp").forward(req, resp);
    }
}
