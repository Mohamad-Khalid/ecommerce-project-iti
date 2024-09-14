package com.laptop.util;

import com.laptop.entity.Category;
import com.laptop.entity.Product;
import com.laptop.service.CategoryService;
import com.laptop.service.CategoryServiceImpl;
import com.laptop.service.ProductService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletContext;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Setter
public class Initializer {
    private static ServletContext servletContext;

    public static void setServletContext(ServletContext servletContext) {
        Initializer.servletContext = servletContext;
    }

    public static void load(){
        loadProducts();
        loadCategories();
        loadFilters();
    }

    public static void loadProducts(){
        ProductService productService = new ProductService();
        List<Product> productsPageOne = productService.getAllProducts(new HashMap<>(),1,8);
        List<Product> productsPageTwo = productService.getAllProducts(new HashMap<>(),2,8);
        servletContext.setAttribute("homeProducts", productsPageOne);
        servletContext.setAttribute("homeProducts2", productsPageTwo);
    }

    public static void loadCategories(){
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.getCategories(1, 10);
        servletContext.setAttribute("categoryList", categories);
    }

    public static void loadFilters(){
        EntityManager em = EntityManagerProvider.getEntityManager();
        List<String> brands = em.createQuery("select distinct brandName from " +
                        "Product p",
                String.class).getResultList();
        servletContext.setAttribute("brandList", brands);

        List<String> processors = em.createQuery("select distinct " +
                        "specs.processor " +
                        "from " +
                        "Product p",
                String.class).getResultList();
        servletContext.setAttribute("processorList", processors);

        List<Integer> memoryList = em.createQuery("select distinct specs" +
                        ".memory " +
                        "from " +
                        "Product p",
                Integer.class).getResultList();
        servletContext.setAttribute("memoryList", memoryList);

        List<String> osList = em.createQuery("select distinct specs" +
                        ".os " +
                        "from " +
                        "Product p",
                String.class).getResultList();
        servletContext.setAttribute("osList", osList);

        List<Integer> batteryList = em.createQuery("select distinct specs" +
                        ".batteryLife " +
                        "from " +
                        "Product p",
                Integer.class).getResultList();
        servletContext.setAttribute("batteryList", batteryList);

        Integer minPrice = em.createQuery("select min(p.price) from " +
                        "Product p",
                Integer.class).getSingleResult();
        minPrice -= minPrice%1000;
        servletContext.setAttribute("minPrice", minPrice);

        Integer maxPrice = em.createQuery("select max(p.price) from " +
                        "Product p",
                Integer.class).getSingleResult();
        maxPrice += 1000 - maxPrice%1000;
        servletContext.setAttribute("maxPrice", maxPrice);
    }
}
