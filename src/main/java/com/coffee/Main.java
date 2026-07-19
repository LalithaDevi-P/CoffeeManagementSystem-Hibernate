package com.coffee;

import com.coffee.dao.ProductDAO;
import com.coffee.entity.CoffeeOrder;
import com.coffee.entity.Customer;
import com.coffee.entity.CustomerProfile;
import com.coffee.entity.Product;
import com.coffee.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAO();

        Session session =
                HibernateUtil.getSessionFactory()
                        .openSession();

        Transaction tx =
                session.beginTransaction();

        Customer customer =
                new Customer(
                        "Lalitha",
                        "lalitha@gmail.com"
                );

        CustomerProfile profile =
                new CustomerProfile(
                        "9876543210",
                        "Hyderabad"
                );

        customer.setProfile(profile);

        CoffeeOrder order1 =
                new CoffeeOrder(
                        LocalDate.now(),
                        250.0
                );

        CoffeeOrder order2 =
                new CoffeeOrder(
                        LocalDate.now(),
                        450.0
                );

        order1.setCustomer(customer);
        order2.setCustomer(customer);

        customer.getOrders().add(order1);
        customer.getOrders().add(order2);

        session.persist(customer);

        tx.commit();
        session.close();

        while (true){
            System.out.println("\n===== Coffee Shop =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Product By ID");
            System.out.println("3. View All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            System.out.print("Enter your choice:");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch){
                case 1 :
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    Product product = new Product(name, price, category);

                    productDAO.save(product);
                    break;

                case 2:
                    System.out.print("Enter Product Id:");
                    Long id = sc.nextLong();
                    Product p =
                            productDAO.findById(id);

                    System.out.println(p);

                    break;
                case 3:
                    List<Product> prods = productDAO.findAll();
                    for(Product pr : prods){
                        System.out.println(pr);
                    }
                    break;

                case 4:
                System.out.print("Enter Product ID: ");
                Long updateId =
                        sc.nextLong();

                Product existing =
                        productDAO.findById(updateId);

                if(existing != null) {

                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    existing.setName(sc.nextLine());

                    System.out.print("Enter New Price: ");
                    existing.setPrice(sc.nextDouble());

                    sc.nextLine();

                    System.out.print("Enter New Category: ");
                    existing.setCategory(sc.nextLine());

                    productDAO.update(existing);

                } else {

                    System.out.println("Product Not Found");
                }

                break;

                case 5:

                    System.out.print("Enter Product ID: ");
                    Long deleteId =
                            sc.nextLong();

                    productDAO.delete(deleteId);

                    break;

                case 6:

                    System.out.println("Thank You");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}