package com.coffee.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory = new Configuration()
            .configure()
            .addAnnotatedClass(com.coffee.entity.Product.class)
            .addAnnotatedClass(com.coffee.entity.Customer.class)
            .addAnnotatedClass(com.coffee.entity.CustomerProfile.class)
            .addAnnotatedClass(com.coffee.entity.CoffeeOrder.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
