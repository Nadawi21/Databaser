package Repositories;

import Data.Customer;
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
import java.util.Scanner;

public class Repository {

    public Customer userCheck(String email, String password) throws IOException, SQLException {

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/Repositories/settings.properties"));

        try (Connection c = DriverManager.getConnection(
                prop.getProperty("ConnectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));

             CallableStatement stm = c.prepareCall("CALL userCheck(?,?,?,?,?)");
        ) {


            stm.setString(1, email);
            stm.setString(2, password);
            stm.registerOutParameter(3, Types.CHAR);
            stm.registerOutParameter(4, Types.VARCHAR);
            stm.registerOutParameter(5, Types.VARCHAR);

            stm.execute();
            String customerPNr = stm.getString(3);
            String customerName = stm.getString(4);
            String customerLastName = stm.getString(5);



            if (customerPNr.equals("error.personnummer")) {
                return new Customer("error.personnummer", "error.förnamn", "error.efternamn ",
                        "", "", 0);
            }
            return new Customer(customerPNr, customerName, customerLastName, email, password, 0);
        }
    }
}












