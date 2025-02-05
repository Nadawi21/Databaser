package TheShoeShop;



import Data.Customer;
import Data.Product;
import Data.Customer;
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





        Repository rp = new Repository();

        List<Product> productList = rp.getProduct();
        productList.forEach(p -> System.out.println(p.getPrice()));
        productList.forEach(p -> System.out.println(p.getBrand()));
        productList.forEach(p -> System.out.println(p.getSize()));


        List<Customer> customerList = rp.getCustomer();
        customerList.forEach(pass -> System.out.println(pass.getPassword()));
        customerList.forEach(p -> System.out.println(p.getEmail()));

    }
}

