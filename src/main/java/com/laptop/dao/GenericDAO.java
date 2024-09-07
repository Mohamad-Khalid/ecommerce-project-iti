package com.laptop.dao;

import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericDAO <T, K> implements DAO <T, K>{
    protected EntityManager em;
    private final Class<T> entityClass;
    public GenericDAO() {
        this.em = EntityManagerProvider.getEntityManager();
        Type genericSuperClass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
        this.entityClass =
                (Class < T >)parameterizedType.getActualTypeArguments()[0];
    }
    @Override
    public T findById(K id) {

        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll(int page, int size) {
        Query query =
                em.createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass);
        query.setFirstResult((page - 1)* size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    @Override
    public T save(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        return t;
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
