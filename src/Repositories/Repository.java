package Repositories;

import Data.Product;

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

    List<Product> getProduct() throws IOException {

    Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\TEMP\\Databaser\\src\\Repositories\\properties"));

            try (Connection c = DriverManager.getConnection(
            prop.getProperty("connectionString"),
            prop.getProperty("name"),
            prop.getProperty("password"));

    Statement stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery("select brand, size, price from Product")
    ) {
        List<Product> Product = new ArrayList<>();

        while (rs.next()) {
            Product temp = new Product();
            String brand = rs.getString("brand");
            temp.setBrand(brand);
            int size = rs.getInt("size");
            temp.setSize(size);
            int price = rs.getInt("price");
            temp.setPrice(price);
            Product.add(temp);
        }

        return Product;


    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }

}
