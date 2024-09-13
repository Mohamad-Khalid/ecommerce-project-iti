package com.laptop.controller.product;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.laptop.dao.ProductDAO;
import com.laptop.dto.ProductWithSpecsDTO;
import com.laptop.entity.Category;
import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import com.laptop.service.CategoryService;
import com.laptop.service.CategoryServiceImpl;
import com.laptop.service.ProductService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
@WebServlet("/dashboard/update-product")
public class UpdateProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");
        if(productId==null)productId="1";

        // Fetch the product from the database using DAO or JPA
        ProductService productService = new ProductService();
        Optional<Product> product =
                productService.getProductById(Integer.parseInt(productId));

        if(product.isPresent()) {
            PrintWriter out = response.getWriter();
            ProductWithSpecsDTO productDto=
                    new ProductWithSpecsDTO(product.get());
            request.setAttribute("product", productDto);
            request.getRequestDispatcher("update-product.jsp").forward(request,
                    response);
            return;
        }
        else{
            response.sendRedirect("products");
            return;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }

        // Parse the JSON object
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(sb.toString(), JsonObject.class);

        // Create Product and ProductSpecs objects
        Product product = new Product();
        ProductSpecs productSpecs = new ProductSpecs();
        List<JsonElement> images = jsonObject.getAsJsonArray("images").asList();

        // Set ProductSpecs properties from the request
        productSpecs.setProcessor(jsonObject.get("processor").getAsString());
        productSpecs.setMemory(Integer.parseInt(jsonObject.get("memory").getAsString()));
        productSpecs.setStorage(jsonObject.get("storage").getAsString());
        productSpecs.setGraphicsCard(jsonObject.get("graphicsCard").getAsString());
        productSpecs.setDisplaySize(jsonObject.get("displaySize").getAsString());
        productSpecs.setBatteryLife(Integer.parseInt(jsonObject.get(
                "batteryLife").getAsString()));
        productSpecs.setOs(jsonObject.get("os").getAsString());
        productSpecs.setWeight(Double.parseDouble(jsonObject.get("weight").getAsString()));

        // Set Product properties from the request
        product.setId(jsonObject.get("id").getAsInt());
        product.setName(jsonObject.get("name").getAsString());
        product.setPrice(Integer.parseInt(jsonObject.get("price").getAsString()));
        product.setDescription(jsonObject.get("description").getAsString());
        product.setStock(Integer.parseInt(jsonObject.get("stock").getAsString()));
        product.setImage(images.getFirst().getAsString());
        product.setBrandName(jsonObject.get("brandName").getAsString());

        // Associate the ProductSpecs with the Product
        product.setSpecs(productSpecs);

        // Now save the product using your service (ProductService assumed here)
        ProductService productService = new ProductService();
        CategoryService categoryService = new CategoryServiceImpl();
        product.setCategory(categoryService.getCategoryById(Integer.parseInt(jsonObject.get(
                "category").getAsString())));

        Product saved = productService.updateWithImages(product,
                images.stream().map(JsonElement::getAsString).toList());

        if(saved != null) {
            resp.setStatus(HttpServletResponse.SC_CREATED);
        }
        else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }


    }
}
