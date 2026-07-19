package com.coffee.dao;

import com.coffee.entity.Product;
import com.coffee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {
    public void save(Product product){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(product);
        transaction.commit();
        session.close();
        System.out.println("Product saved successfully");
    }

   public Product findById(Long id){
       Session session = HibernateUtil.getSessionFactory().openSession();
       Product prod = session.get(Product.class, id);
        session.close();
       return prod;

   }

   public List<Product> findAll(){
       Session session = HibernateUtil.getSessionFactory().openSession();
       List<Product> prods = session.createQuery("from Product",
               Product.class).getResultList();
       session.close();
       return prods;
   }

    public void update(Product product) {

        Session session =
                HibernateUtil.getSessionFactory()
                        .openSession();

        Transaction tx =
                session.beginTransaction();

        session.merge(product);

        tx.commit();
        session.close();

        System.out.println("Product Updated Successfully");
    }

    public void delete(Long id) {

        Session session =
                HibernateUtil.getSessionFactory()
                        .openSession();

        Transaction tx =
                session.beginTransaction();

        Product product =
                session.get(Product.class, id);

        if(product != null) {
            session.remove(product);
            System.out.println("Product Deleted Successfully");
        } else {
            System.out.println("Product Not Found");
        }

        tx.commit();
        session.close();
    }
}

