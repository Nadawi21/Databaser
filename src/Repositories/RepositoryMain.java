package Repositories;

import Data.Product;
import java.util.List;

import java.io.IOException;

public class RepositoryMain {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Repository rp = new Repository();
        List<Product> prodictList = rp.getProduct();
        prodictList.forEach(prod -> System.out.println(Product.getPrice()));
    }
}
