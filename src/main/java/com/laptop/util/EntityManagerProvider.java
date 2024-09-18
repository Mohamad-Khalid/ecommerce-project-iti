package com.laptop.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerProvider {
    private static final ThreadLocal<EntityManager> entityManagerThreadLocal =
            new ThreadLocal<>();
    private static EntityManagerFactory emf = null;

    public static EntityManager getEntityManager() {
        if(entityManagerThreadLocal.get() == null){
            setEntityManager(emf.createEntityManager());
        }
        return entityManagerThreadLocal.get();
    }

    public static void setEntityManager(EntityManager entityManager) {
        entityManagerThreadLocal.set(entityManager);
    }

    public static void clearEntityManager() {
        getEntityManager().clear();
        getEntityManager().close();
        entityManagerThreadLocal.remove();
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static void setEmf(EntityManagerFactory emf) {
        EntityManagerProvider.emf = emf;
    }
}
