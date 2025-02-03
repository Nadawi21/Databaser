import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connection {

    public class skoShoppen {
        public static void main(String[]args) throws ClassNotFoundException {
            try (java.sql.Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/SkoShoppen?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                    "Nada",
                    "secretpassword");
                 Statement stmt = c.createStatement();
                 ResultSet rs = stmt.executeQuery("select märke, storlek, färgnamn from Produkt")
            ){
                List<Produkt> Produkt = new ArrayList<>();

                while (rs.next()){
                    Produkt temp = new Produkt();

                    String märke = rs.getString("märke");
                    temp.setMärke(märke);

                    int storlek = rs.getInt("storlek");
                    temp.setStorlek(storlek);

                    String färgnamn= rs.getString("färgnamn");
                    temp.setFärgnamn(färgnamn);
                    Produkt.add(temp);
                }

                Produkt.forEach(Product -> System.out.println(Product.getMärke()));


            }catch (SQLException e){
                throw new RuntimeException(e);
            }
        }
    }

}
