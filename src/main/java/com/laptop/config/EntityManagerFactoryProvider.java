package com.laptop.config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {
    private static EntityManagerFactory entityManagerFactory;
    public static EntityManagerFactory create(){
        if(entityManagerFactory == null){
            synchronized (Persistence.class){
                if(entityManagerFactory == null){
                    entityManagerFactory =
                            Persistence.createEntityManagerFactory("web");
                }
            }
        }
        return entityManagerFactory;
    }
    public static void close(){
        if(entityManagerFactory != null){
            entityManagerFactory.close();
        }
        entityManagerFactory = null;
    }
}
