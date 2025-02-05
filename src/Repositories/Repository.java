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
        List<Product> productList = new ArrayList<>();

        while (rs.next()) {
            Product temp = new Product();
            String brand = rs.getString("märke");
            temp.setBrand(brand);
            int size = rs.getInt("storlek");
            temp.setSize(size);
            int price = rs.getInt("pris");
            temp.setPrice(price);
            productList.add(temp);
            int productId = rs.getInt("produktId");
            temp.setBrand(brand);
        }

        return productList;


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

            List<Customer> customerList = new ArrayList<>();

            while (rs.next()) {
                Customer temp = new Customer();
                String email = rs.getString("email");
                temp.setEmail(email);
                String password = rs.getString("lösenord");
                temp.setPassword(password);
                customerList.add(temp);
                String personalNumber = rs.getString("personnummer");
                temp.setPassword(personalNumber);
                customerList.add(temp);
            }

            return customerList;

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

            List<OrderItem> orderItemList = new ArrayList<>();

            while (rs.next()) {
                OrderItem temp = new OrderItem();
                int orderIdFK = rs.getInt("beställningsidFK");
                temp.setOrderIdFK(orderIdFK);
                int productIdFK = rs.getInt("produktidFK");
                temp.setProductIdFK (productIdFK);
                orderItemList.add(temp);
                int amount = rs.getInt("antal");
                temp.setAmount (amount);
                orderItemList.add(temp);
            }

            return orderItemList;

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

            List<Order> orderList = new ArrayList<>();

            while (rs.next()) {
                Order temp = new Order();
                int orderId = rs.getInt("beställningsid");
                temp.setOrderId(orderId);
                String PersonalNumberFK = rs.getString("personnummerFK");
                temp.setPersonalNumberFK (PersonalNumberFK);
                OrderStatus status = OrderStatus.valueOf(rs.getString("status"));
                temp.setStatus (status);
                orderList.add(temp);
            }

            return orderList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Color
    public List<Color> getColor() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

        try (Connection c = DriverManager.getConnection(
                prop.getProperty("ConnectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT colorId, colorName FROM Color")) {

            List<Color> colorList = new ArrayList<>(); // Listan heter colorList

            while (rs.next()) {
                Color temp = new Color();
                int colorId = rs.getInt("colorId");
                temp.setColorId(colorId);
                String colorName = rs.getString("colorName");
                temp.setColorName(colorName);
                colorList.add(temp);
            }

            return colorList; // Returnera colorList

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> getCategory() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

        try (Connection c = DriverManager.getConnection(
                prop.getProperty("ConnectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT kategoriId, typ FROM kategori")) {

            List<Category> categoryList = new ArrayList<>(); // Listan heter categoryList

            while (rs.next()) {
                Category temp = new Category();
                int categoryId = rs.getInt("kategoriId");
                temp.setCategoryId(categoryId);
                String shoeType = rs.getString("typ");
                temp.setShoeType(shoeType);
                categoryList.add(temp);
            }

            return categoryList; // Returnera categoryList

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Categorise

    public List<Categorise> getCategorise() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

        try (Connection c = DriverManager.getConnection(
                prop.getProperty("ConnectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT produktIdFK, kategoriIdFK FROM kategoriserar")) {

            List<Categorise> categoriseList = new ArrayList<>(); // Listan heter categoriseList

            while (rs.next()) {
                Categorise temp = new Categorise();
                int productIdFK = rs.getInt("produktIdFK");
                temp.setProductIdFK(productIdFK);
                int categoryIdFK = rs.getInt("kategoriIdFK");
                temp.setCategoryIdFK(categoryIdFK);
                categoriseList.add(temp);
            }

            return categoriseList; // Returnera categoriseList

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}

