package TheShoeShop;



import Data.Customer;
import Data.Product;
import Repositories.Repository;

import java.sql.SQLException;
import java.util.List;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {

        Repository repo = new Repository();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your email: ");
        String email = input.nextLine();
        System.out.println("Enter your password: ");
        String password = input.nextLine();

        Customer user = repo.userCheck(email, password);
        System.out.println(user);






        //List<Product> productList = rp.getProduct();
       // productList.forEach(prod -> System.out.println(Product.getPrice()));

    }
}

