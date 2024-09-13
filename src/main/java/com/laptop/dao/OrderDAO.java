package com.laptop.dao;

import com.laptop.entity.Order;
import com.laptop.entity.OrderItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.*;

public class OrderDAO extends GenericDAO<Order,Integer> {
    public OrderDAO() {
        super();
    }

    public List<Order> find(Map<String,Object> map, int page, int size) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> root = cq.from(Order.class);

        List<Predicate> predicates = new ArrayList<>();

        if(map.containsKey("customer_id")){
                predicates.add(cb.equal(root.get("customer").<Integer>get("id"), map.get(
                    "customer_id")));
        }
        if(map.containsKey("min_date")){
            predicates.add(cb.greaterThanOrEqualTo(root.<Date>get("date"),
                    (Date)map.get("min_date")));
        }
        if(map.containsKey("max_date")){
            predicates.add(cb.lessThanOrEqualTo(root.<Date>get("date"),
                    (Date)map.get("max_date")));
        }
        if(map.containsKey("min_price")){
            predicates.add(cb.greaterThanOrEqualTo(root.<Integer>get("totalPrice"),
                    (Integer)map.get("min_price")));
        }
        if(map.containsKey("max_price")){
            predicates.add(cb.lessThanOrEqualTo(root.<Integer>get("totalPrice"),
                    (Integer) map.get("max_price")));
        }
        if (map.containsKey("state")) {
            predicates.add(cb.equal(root.<String>get("state"), (String)map.get("state")));
        }

        cq.where(cb.and(predicates.toArray(new Predicate[0])));
        Query query = em.createQuery(cq);
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query.getResultList();

    }

    public Order saveOrder(Order order, Set<OrderItem> orderItems) {
        em.getTransaction().begin();
        em.persist(order);
        System.out.println(orderItems);
        for(OrderItem orderItem : orderItems){
            em.persist(orderItem);
        }
        em.getTransaction().commit();
        return order;
    }

}
