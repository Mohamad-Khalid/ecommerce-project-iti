package com.laptop;

import com.laptop.dao.CartHasProductDAO;
import com.laptop.dao.CustomerDAO;
import com.laptop.dao.ProductDAO;
import com.laptop.entity.CartHasProduct;
import com.laptop.entity.CartHasProductID;
import com.laptop.entity.Customer;
import com.laptop.service.CartService;
import com.laptop.util.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!");
    }
}
