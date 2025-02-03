package Repositories;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Repository {

    Properties prop = new Properties();
        prop.load(new FileInputStream("src/Repositories/settings.properties"));

                try (java.sql.Connection c = DriverManager.getConnection(
            prop.getProperty("connectionString"),
            prop.getProperty("name"),
            prop.getProperty("password"));

    Statement stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery("select märke, storlek, pris from Produkt")
                ) {
        List<Product> Produkt = new ArrayList<>();

        while (rs.next()) {
            Product temp = new Product();

            String märke = rs.getString("märke");
            temp.setMärke(märke);

            int storlek = rs.getInt("storlek");
            temp.setStorlek(storlek);

            int pris = rs.getInt("pris");
            temp.setPris(pris);

            Produkt.add(temp);
        }

        Produkt.forEach(Product -> System.out.println(Product.getMärke()));


    } catch (
    SQLException e) {
        throw new RuntimeException(e);
    }
}
