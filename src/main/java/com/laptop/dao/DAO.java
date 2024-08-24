package com.laptop.dao;

import java.util.List;

public interface DAO <T, K>{
    T findById(K id);
    List<T> findAll();
    T save(T t);
    void delete(T t);
    T update(T t);
}
