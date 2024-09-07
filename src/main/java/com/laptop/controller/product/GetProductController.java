package com.laptop.controller.product;

import com.laptop.entity.Product;
import com.laptop.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public class GetProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductService productService = new ProductService();
        Optional<Product> product =
                productService.getProductById(Integer.parseInt(req.getParameter("id")));

        if(product.isPresent()) {
            ///Handle success
        }
        else{
            ///Handle fail
        }
    }
}
