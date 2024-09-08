package com.laptop.controller.product;

import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import com.laptop.service.CategoryService;
import com.laptop.service.CategoryServiceImpl;
import com.laptop.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/products")
public class AddProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create Product and ProductSpecs objects
        Product product = new Product();
        ProductSpecs productSpecs = new ProductSpecs();

        // Set ProductSpecs properties from the request
        productSpecs.setProcessor(req.getParameter("processor"));
        productSpecs.setMemory(Integer.parseInt(req.getParameter("memory")));
        productSpecs.setStorage(req.getParameter("storage"));
        productSpecs.setGraphicsCard(req.getParameter("graphicsCard"));
        productSpecs.setDisplaySize(req.getParameter("displaySize"));
        productSpecs.setBatteryLife(Integer.parseInt(req.getParameter("batteryLife")));
        productSpecs.setOs(req.getParameter("os"));
        productSpecs.setWeight(Double.parseDouble(req.getParameter("weight")));

        // Set Product properties from the request
        product.setName(req.getParameter("name"));
        product.setPrice(Integer.parseInt(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setStock(Integer.parseInt(req.getParameter("stock")));
        product.setImage(req.getParameter("image"));
        product.setBrandName(req.getParameter("brandName"));

        // Associate the ProductSpecs with the Product
        product.setSpecs(productSpecs);

        // Now save the product using your service (ProductService assumed here)
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryServiceImpl();
        product.setCategory(categoryService.getCategoryById(Integer.parseInt(req.getParameter(
                "category_id"))));

        Product saved = productService.save(product);
        if(saved != null) {
            ///Handle success
        }
        else {
            ///Handle failed
        }
    }
}
