package com.laptop.dao;

import com.laptop.config.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class GenericDAO <T, K> implements DAO <T, K>{
    protected EntityManager em;
    private final Class<T> entityClass;
    public GenericDAO(Class<T> entityClass) {
        EntityManagerFactory emf = EntityManagerFactoryProvider.create();
        em = emf.createEntityManager();
        this.entityClass = entityClass;
    }
    @Override
    public T findById(K id) {

        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return em.createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass).getResultList();
    }

    @Override
    public T save(T t) {
        em.getTransaction().begin();
        T entity = em.merge(t);
        em.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(T t) {
        em.getTransaction().begin();
        em.remove(em.merge(t));
        em.getTransaction().commit();
    }

    @Override
    public T update(T t) {
        em.getTransaction().begin();
        T entity = em.merge(t);
        em.getTransaction().commit();
        return entity;
    }
}
