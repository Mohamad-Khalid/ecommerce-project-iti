package com.laptop.service;

import com.laptop.dao.ProductDAO;
import com.laptop.entity.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductService {

    ProductDAO productDAO;
    public ProductService(){
        productDAO = new ProductDAO();
    }

    // Create a Product
    public Product save(Product product) {
        return productDAO.save(product);
    }


    // Update a Product
    public Product update(Product product) {
        return productDAO.update(product);
    }

    // Get a Product by ID
    public Optional<Product> getProductById(Integer id) {
        Product product = productDAO.findById(id);
        return Optional.ofNullable(product);
    }

    // Get all Products
    public List<Product> getAllProducts(Map<String, Object> filter, int page,
                                        int size) {
        List<Product> products = productDAO.findByFilter(filter,page, size);
        return products;
    }

    // Delete Product by ID
    public boolean deleteProduct(Integer id) {
        return productDAO.deleteById(id);
    }
}
