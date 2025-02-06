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

    private  String ConnectionString;
    private  String name;
    private  String password;

    //Properties
    public  Repository (){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/Repositories/properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ConnectionString = prop.getProperty("ConnectionString");
        name = prop.getProperty("name");
        password = prop.getProperty("password");
    }
    //User check
    public Customer userCheck(String email, String lösenord) throws IOException, SQLException {

        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);

             CallableStatement stm = c.prepareCall("CALL userCheck(?,?,?,?,?)");
        ) {


            stm.setString(1, email);
            stm.setString(2, lösenord);
            stm.registerOutParameter(3, Types.CHAR);
            stm.registerOutParameter(4, Types.VARCHAR);
            stm.registerOutParameter(5, Types.VARCHAR);

            stm.execute();
            String customerPNr = stm.getString(3);
            String customerName = stm.getString(4);
            String customerLastName = stm.getString(5);

            if(customerPNr == null) customerPNr = "error.personnummer";
            if(customerName == null) customerName = "error.förnamn";
            if(customerLastName == null) customerLastName = "error.efternamn";

            if (customerPNr.equals("error.personnummer")) {
                return new Customer("error.personnummer", "error.förnamn", "error.efternamn ",
                        "", "", 0);
            }
            return new Customer(customerPNr, customerName, customerLastName, email, lösenord, 0);
        }
    }


    //Add to cart

    public Integer addToCart(String choosenProductId, String choosenNumber, String personnummer) {
        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);
             CallableStatement stm = c.prepareCall("CALL AddToCart(?,?,?,?,?)")) {


            int productId = Integer.parseInt(choosenProductId);
            int quantity = Integer.parseInt(choosenNumber);
            java.sql.Date orderDate = new java.sql.Date(System.currentTimeMillis());


            stm.setString(1, personnummer);
            stm.setInt(2, productId);
            stm.setString(3, null);
            stm.setDate(4, orderDate);
            stm.setInt(5, quantity);

            stm.execute();


            try (Statement stmt = c.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "SELECT BeställningsId FROM Beställning " +
                                 "WHERE personnummerFK = '" + personnummer + "' " +
                                 "AND status = 'active'")) {
                if (rs.next()) {
                    return rs.getInt("BeställningsId");
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




//Product
    public  List<Product> getProduct() throws IOException {

        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);

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
                int productId = rs.getInt("produktId");
                temp.setProductId(productId);
                productList.add(temp);
            }

            return productList;


        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
    }
    

    //Customer
    public List<Customer> getCustomer() throws IOException {
        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select personnummer, email, lösenord from kund")) {

            List<Customer> customerList = new ArrayList<>();

            while (rs.next()) {
                Customer temp = new Customer();
                String email = rs.getString("email");
                temp.setEmail(email);
                String password = rs.getString("lösenord");
                temp.setPassword(password);
                String personalNumber = rs.getString("personnummer");
                temp.setPersonalNumber(personalNumber);
                customerList.add(temp);
            }

            return customerList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //OrderItem
    public List<OrderItem> getOrderItem() throws IOException {
        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery("select beställningsidFK,  produktidFK, antal from kundorder")) {

            List<OrderItem> orderItemList = new ArrayList<>();

            while (rs.next()) {
                OrderItem temp = new OrderItem();
                int orderIdFK = rs.getInt("beställningsidFK");
                temp.setOrderIdFK(orderIdFK);
                int productIdFK = rs.getInt("produktidFK");
                temp.setProductIdFK (productIdFK);
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

        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);

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

        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);

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

        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);

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

        try (Connection c = DriverManager.getConnection(
                ConnectionString,
                name,
                password);

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

    //Get category
    public List<Product> getProductBasedOnCategory(Integer chosenCategoryId) throws IOException {

        try (Connection c = DriverManager.getConnection(ConnectionString, name, password);
             PreparedStatement stmt = c.prepareStatement("SELECT produktid, märke, storlek, pris FROM produkt " +
                     "LEFT JOIN kategoriserar ON kategoriserar.produktidfk = produkt.produktid " +
                     "WHERE kategoriserar.kategoriidfk = ?")){
             stmt.setInt(1, chosenCategoryId);
             ResultSet rs = stmt.executeQuery() ;



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
                    temp.setProductId(productId);
                }

                return productList;

            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }
















