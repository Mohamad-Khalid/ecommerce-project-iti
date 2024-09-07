package com.laptop.controller.product;

import com.laptop.entity.Category;
import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import com.laptop.service.CategoryService;
import com.laptop.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class UpdateProductController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try {
            // Parse product-related parameters
            Integer productId = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String priceStr = req.getParameter("price");
            String description = req.getParameter("description");
            String stockStr = req.getParameter("stock");
            String image = req.getParameter("image");
            String brandName = req.getParameter("brandName");
            String categoryIdStr = req.getParameter("category");

            // Parse ProductSpecs-related parameters
            String processor = req.getParameter("processor");
            String memoryStr = req.getParameter("memory");
            String storage = req.getParameter("storage");
            String graphicsCard = req.getParameter("graphicsCard");
            String displaySize = req.getParameter("displaySize");
            String batteryLifeStr = req.getParameter("batteryLife");
            String os = req.getParameter("os");
            String weightStr = req.getParameter("weight");

            // Create and populate the Product and ProductSpecs objects
            ProductService productService = new ProductService();
            CategoryService categoryService = new CategoryService();
            Optional<Product> product =
                    productService.getProductById(productId);
            if(product.isEmpty()){
                ///Handle Fail
                return ;
            }
            Product updatedProduct = product.get();
            if (name != null) updatedProduct.setName(name);
            if (priceStr != null) updatedProduct.setPrice(Integer.parseInt(priceStr));
            if (description != null) updatedProduct.setDescription(description);
            if (stockStr != null) updatedProduct.setStock(Integer.parseInt(stockStr));
            if (image != null) updatedProduct.setImage(image);
            if (brandName != null) updatedProduct.setBrandName(brandName);
            if (categoryIdStr != null) {
                Integer categoryId = Integer.parseInt(categoryIdStr);
                Category category = categoryService.findById(categoryId);
                updatedProduct.setCategory(category);
            }

            // Prepare ProductSpecs object with updated data
            ProductSpecs updatedSpecs = updatedProduct.getSpecs();
            if (processor != null) updatedSpecs.setProcessor(processor);
            if (memoryStr != null) updatedSpecs.setMemory(Integer.parseInt(memoryStr));
            if (storage != null) updatedSpecs.setStorage(storage);
            if (graphicsCard != null) updatedSpecs.setGraphicsCard(graphicsCard);
            if (displaySize != null) updatedSpecs.setDisplaySize(displaySize);
            if (batteryLifeStr != null) updatedSpecs.setBatteryLife(Integer.parseInt(batteryLifeStr));
            if (os != null) updatedSpecs.setOs(os);
            if (weightStr != null) updatedSpecs.setWeight(Double.parseDouble(weightStr));

            // Attach updated specs to product
            updatedProduct.setSpecs(updatedSpecs);

            // Update the product using service class
            Product saved = productService.update(updatedProduct);
            boolean isUpdated = (saved != null);

            if (isUpdated) {
                out.write("{\"status\":\"success\", \"message\":\"Product updated successfully.\"}");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                out.write("{\"status\":\"error\", \"message\":\"Failed to update product.\"}");
            }

        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.write("{\"status\":\"error\", \"message\":\"Invalid input data.\"}");
        } finally {
            out.flush();
            out.close();
        }


    }
}
