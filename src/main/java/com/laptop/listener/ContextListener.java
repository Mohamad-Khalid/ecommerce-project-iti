package com.laptop.listener;

import com.laptop.entity.Product;
import com.laptop.service.ProductService;
import com.laptop.util.EntityManagerProvider;
import com.laptop.util.Initializer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContextListener implements ServletContextListener {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // initialize EntityManagerFactory
        EntityManagerFactory emf = null;
        try {
            emf =
                    Persistence.createEntityManagerFactory("web");
            sce.getServletContext().setAttribute("emf", emf);

        } catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex );
            throw new RuntimeException(ex);
        }

        //Load products for home page
        try {
            EntityManager entityManager = emf.createEntityManager();
            EntityManagerProvider.setEntityManager(entityManager);

            Initializer.setServletContext(sce.getServletContext());
            Initializer.load();

            EntityManagerProvider.clearEntityManager();
        }
        catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex );
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
        emf.close();

    }

}
