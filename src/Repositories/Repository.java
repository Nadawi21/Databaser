package Repositories;

import Data.*;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.*;
import java.io.FileInputStream;

public class Repository {

    //Product
   public  List<Product> getProduct() throws IOException {

    Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

            try (Connection c = DriverManager.getConnection(
            prop.getProperty("ConnectionString"),
            prop.getProperty("name"),
            prop.getProperty("password"));

    Statement stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery("select produktId, märke, storlek, pris from Produkt")
    ) {
        List<Product> Product = new ArrayList<>();

        while (rs.next()) {
            Product temp = new Product();
            String brand = rs.getString("märke");
            temp.setBrand(brand);
            int size = rs.getInt("storlek");
            temp.setSize(size);
            int price = rs.getInt("pris");
            temp.setPrice(price);
            Product.add(temp);
            int productId = rs.getInt("produktId");
            temp.setBrand(brand);
        }

        return Product;


    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }

    }

    //Customer
    public List<Customer> getCustomer() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

        try (Connection c = DriverManager.getConnection(
                prop.getProperty("ConnectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select personnummer, email, lösenord from kund")) {

            List<Customer> customer = new ArrayList<>();

            while (rs.next()) {
                Customer temp = new Customer();
                String email = rs.getString("email");
                temp.setEmail(email);
                String password = rs.getString("lösenord");
                temp.setPassword(password);
                customer.add(temp);
                String personalNumber = rs.getString("personnummer");
                temp.setPassword(personalNumber);
                customer.add(temp);
            }

            return customer;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //OrderItem
    public List<OrderItem> getOrderItem() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

        try (Connection c = DriverManager.getConnection(
                prop.getProperty("ConnectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select beställningsidFK,  produktidFK, antal from kundorder")) {

            List<OrderItem> OrderItem = new ArrayList<>();

            while (rs.next()) {
                OrderItem temp = new OrderItem();
                int orderIdFK = rs.getInt("beställningsidFK");
                temp.setOrderIdFK(orderIdFK);
                int productIdFK = rs.getInt("produktidFK");
                temp.setProductIdFK (productIdFK);
                OrderItem.add(temp);
                int amount = rs.getInt("antal");
                temp.setAmount (amount);
                OrderItem.add(temp);
            }

            return OrderItem;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Order
    public List<Order> getOrder() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

        try (Connection c = DriverManager.getConnection(
                prop.getProperty("ConnectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select beställningsid,  personnummerFK, status from beställning")) {

            List<Order> Order = new ArrayList<>();

            while (rs.next()) {
                Order temp = new Order();
                int orderId = rs.getInt("beställningsid");
                temp.setOrderId(orderId);
                String PersonalNumberFK = rs.getString("personnummerFK");
                temp.setPersonalNumberFK (PersonalNumberFK);
                OrderStatus status = OrderStatus.valueOf(rs.getString("status"));
                temp.setStatus (status);
                Order.add(temp);
            }

            return Order;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

