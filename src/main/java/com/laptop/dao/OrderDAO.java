package com.laptop.dao;

import com.laptop.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderDAO extends GenericDAO<Order,Integer> {
    public OrderDAO() {
        super();
    }

    public List<Order> find(Map<String,Object> map, int page, int size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> root = cq.from(Order.class);
        if(map.containsKey("customer_id")){
            cq.where(cb.equal(root.get("customer").<Integer>get("id"), map.get(
                    "customer_id")));
        }
        if(map.containsKey("min_date")){
            cq.where(cb.greaterThanOrEqualTo(root.<Date>get("date"),
                    (Date)map.get("min_date")));
        }
        if(map.containsKey("max_date")){
            cq.where(cb.lessThanOrEqualTo(root.<Date>get("date"),
                    (Date)map.get("max_date")));
        }
        if(map.containsKey("min_price")){
            cq.where(cb.greaterThanOrEqualTo(root.<Integer>get("totalPrice"),
                    (Integer)map.get("min_price")));
        }
        if(map.containsKey("max_price")){
            cq.where(cb.lessThanOrEqualTo(root.<Integer>get("totalPrice"),
                    (Integer) map.get("max_price")));
        }
        if (map.containsKey("state")) {
            cq.where(cb.equal(root.<String>get("state"), (String)map.get("state")));
        }
        Query query = em.createQuery(cq);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();

    }
}
