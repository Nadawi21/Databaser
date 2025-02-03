import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Connection {
    public static void main(String[] args) throws ClassNotFoundException {

                try (java.sql.Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SkoShoppen?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                        "root",
                        "k5**t6c!]6^HJv");
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


                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }



