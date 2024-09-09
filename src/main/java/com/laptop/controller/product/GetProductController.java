package com.laptop.controller.product;

import com.google.gson.Gson;
import com.laptop.dto.ProductDTO;
import com.laptop.dto.ProductWithSpecsDTO;
import com.laptop.entity.Product;
import com.laptop.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
@WebServlet("/web/product")
public class GetProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        ProductService productService = new ProductService();
        Optional<Product> product =
                productService.getProductById(Integer.parseInt(req.getParameter("id")));

        if(product.isPresent()) {
            PrintWriter out = resp.getWriter();
            ProductWithSpecsDTO productDto=
                    new ProductWithSpecsDTO(product.get());
            Gson gson = new Gson();
            out.write(gson.toJson(productDto, ProductWithSpecsDTO.class));
        }
        else{
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            ///Handle fail
        }
    }
}
