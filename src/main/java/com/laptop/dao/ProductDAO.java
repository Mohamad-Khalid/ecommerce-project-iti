package com.laptop.dao;

import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Map;

public class ProductDAO extends GenericDAO<Product,Integer>{
    public ProductDAO(EntityManager em) {
        super(Product.class, em);
    }

    public List<Product> findByCategory(String name) {
        TypedQuery<Product> query = em.createQuery("from Product p where p.category.name = :name ", Product.class).setParameter("name",name);
        return query.getResultList();
    }

    public List<Product> findByFilter(Map<String, Object> filter, int page,
                                      int size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        if(filter.containsKey("processor")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").get(
                    "processor"),
                    (String)filter.get("processor")));
        }
        if(filter.containsKey("memory")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").<Integer>get("memory"), (Integer)filter.get("memory")));
        }
        if(filter.containsKey("storage")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").get("storage"), (String)filter.get("storage")));
        }
        if(filter.containsKey("graphicsCard")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").get("graphicsCard"), (String)filter.get("graphicsCard")));
        }
        if(filter.containsKey("displaySize")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").get("displaySize"), (String)filter.get("displaySize")));
        }
        if(filter.containsKey("batteryLife")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").<Integer>get("batteryLife"), (Integer)filter.get("batteryLife")));
        }
        if(filter.containsKey("os")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").get("os"), (String)filter.get("os")));
        }
        if(filter.containsKey("weight")){
            cq.where(cb.equal(product.<ProductSpecs>get("description").<Double>get("weight"), (Double)filter.get("weight")));
        }
        Query query =  em.createQuery(cq);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

}
