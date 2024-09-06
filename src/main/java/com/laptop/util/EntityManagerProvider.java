package com.laptop.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EntityManagerProvider {
    private static final ThreadLocal<EntityManager> entityManagerThreadLocal =
            new ThreadLocal<>();

    public static EntityManager getEntityManager() {
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
}
