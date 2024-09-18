package com.laptop.listener;

import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        EntityManagerFactory emf =
                (EntityManagerFactory) sre.getServletRequest().getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        EntityManagerProvider.setEntityManager(em);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        EntityManagerProvider.clearEntityManager();
    }
}
