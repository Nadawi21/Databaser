package TheShoeShop;



import Data.Product;
import Data.Customer;
import Repositories.Repository;

import java.util.List;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

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

