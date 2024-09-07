package com.laptop.listener;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("web");
            sce.getServletContext().setAttribute("emf", emf);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory emf = (EntityManagerFactory) sce.getServletContext().getAttribute("emf");
        emf.close();

    }

}
