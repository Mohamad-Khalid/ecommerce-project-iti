package com.laptop.dao;

import com.laptop.entity.Category;
import com.laptop.entity.Image;
import com.laptop.entity.Product;
import com.laptop.entity.ProductSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDAO extends GenericDAO<Product,Integer>{
    public ProductDAO() {
        super();
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

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(product.<Boolean>get("deleted"),false));

        if(filter.containsKey("category")){
            predicates.add(cb.equal(product.<Category>get("category").<Integer>get(
                            "id"),
                    (Integer)filter.get("category")));
        }

        if(filter.containsKey("brand")){
            predicates.add(cb.equal(product.<String>get("brandName"),
                    filter.get("brand")));
        }

        if(filter.containsKey("processor")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get(
                    "processor"),
                    (String)filter.get("processor")));
        }
        if(filter.containsKey("memory")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").<Integer>get("memory"), (Integer)filter.get("memory")));
        }
        if(filter.containsKey("storage")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("storage"), (String)filter.get("storage")));
        }
        if(filter.containsKey("graphicsCard")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("graphicsCard"), (String)filter.get("graphicsCard")));
        }
        if(filter.containsKey("displaySize")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("displaySize"), (String)filter.get("displaySize")));
        }
        if(filter.containsKey("batteryLife")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").<Integer>get("batteryLife"), (Integer)filter.get("batteryLife")));
        }
        if(filter.containsKey("os")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("os"), (String)filter.get("os")));
        }

        if(filter.containsKey("min-price")){
            predicates.add(cb.greaterThanOrEqualTo(product.<Integer>get("price"),
                    (Integer)filter.get("min-price")));
        }
        if(filter.containsKey("max-price")){
            predicates.add(cb.lessThanOrEqualTo(product.<Integer>get("price"),
                    (Integer)filter.get("max-price")));
        }
        cq.where(predicates.toArray(new Predicate[0]));
        Query query =  em.createQuery(cq);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }

    public Long countByFilter(Map<String, Object> filter, int page,
                                      int size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(product.<Boolean>get("deleted"),false));

        if(filter.containsKey("category")){
            predicates.add(cb.equal(product.<Category>get("category").<Integer>get(
                            "id"),
                    (Integer)filter.get("category")));
        }

        if(filter.containsKey("brand")){
            predicates.add(cb.equal(product.<String>get("brandName"),
                    filter.get("brand")));
        }

        if(filter.containsKey("processor")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get(
                            "processor"),
                    (String)filter.get("processor")));
        }
        if(filter.containsKey("memory")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").<Integer>get("memory"), (Integer)filter.get("memory")));
        }
        if(filter.containsKey("storage")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("storage"), (String)filter.get("storage")));
        }
        if(filter.containsKey("graphicsCard")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("graphicsCard"), (String)filter.get("graphicsCard")));
        }
        if(filter.containsKey("displaySize")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("displaySize"), (String)filter.get("displaySize")));
        }
        if(filter.containsKey("batteryLife")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").<Integer>get("batteryLife"), (Integer)filter.get("batteryLife")));
        }
        if(filter.containsKey("os")){
            predicates.add(cb.equal(product.<ProductSpecs>get("specs").get("os"), (String)filter.get("os")));
        }

        if(filter.containsKey("min-price")){
            predicates.add(cb.greaterThanOrEqualTo(product.<Integer>get("price"),
                    (Integer)filter.get("min-price")));
        }
        if(filter.containsKey("max-price")){
            predicates.add(cb.lessThanOrEqualTo(product.<Integer>get("price"),
                    (Integer)filter.get("max-price")));
        }

        Query query =
                em.createQuery(cq.select(cb.count(product)).where(cb.and(predicates.toArray(new Predicate[0]))));
        return (Long) query.getSingleResult();
    }


    public boolean deleteById(int id) {
        try{
            Product product = findById(id);
            em.getTransaction().begin();
            product.setDeleted(true);
            em.getTransaction().commit();;
            return true;
        }
        catch (Exception e){
            em.getTransaction().rollback();
            return false;
        }
    }

    public Product addWithImages(Product product, List<String> imageUrls) {
        try {
            em.getTransaction().begin();
            em.persist(product);
            for(int i = 1; i < imageUrls.size(); i++){
                String imageUrl = imageUrls.get(i);
                Image image = new Image();
                image.setUrl(imageUrl);
                image.setProduct(product);
                em.persist(image);
            }
            em.getTransaction().commit();
            return product;
        }
        catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }

    }

    public Product updateWithImages(Product product, List<String> imageUrls) {
        try {
            em.getTransaction().begin();
            for(Image image : product.getImages()){
                em.remove(image);
            }
            product = em.merge(product);
            for(int i = 1; i < imageUrls.size(); i++){
                String imageUrl = imageUrls.get(i);
                Image image = new Image();
                image.setUrl(imageUrl);
                image.setProduct(product);
                em.persist(image);
            }
            em.getTransaction().commit();
            return product;
        }
        catch (Exception e){
            em.getTransaction().rollback();
            return null;
        }

    }

}
