package TheShoeShop;



import Data.Product;
import Repositories.Repository;

import java.util.List;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Repository rp = new Repository();
        List<Product> productList = rp.getProduct();
        //      prodictList.forEach(prod -> System.out.println(Product.getPrice()));

    }
}

