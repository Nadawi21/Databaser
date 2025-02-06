package TheShoeShop;
import Data.Category;
import Data.Order;
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

        System.out.println("Choose a category");
        List<Category> categoryList = repo.getCategory();
        categoryList.forEach(st -> System.out.println(st.getShoeType()));
        String chosenCategory = input.nextLine();


        Integer chosenCategoryId = Category.getCategoryIdByShoeType(categoryList, chosenCategory);
        List<Product> productList = repo.getProductBasedOnCategory(chosenCategoryId);

        productList.forEach(st -> System.out.println("ProductId:"+st.getProductId()+
                "\n"+"Size:"+st.getSize()+"\n"+"Price:"+st.getPrice()+"\n"+"Brand:"+st.getBrand()
                +"\n"+"--------------------------"+"\n"));
        System.out.println("Choose a product via id");
        String choosenProductId = input.nextLine();
        System.out.println("write number of product");
        String choosenNumber = input.nextLine();
        repo.addToCart(choosenProductId, choosenNumber, user.getPersonalNumber());
        System.out.println("-");

        try {
            Integer orderId = repo.addToCart(choosenProductId, choosenNumber, user.getPersonalNumber());
            if (orderId != null) {
                System.out.println("Products added to cart successfully! Order ID: " + orderId);
            } else {
                System.out.println("Failed to add products to cart.");
            }
        } catch (RuntimeException e) {
            System.out.println("Error adding to cart: " + e.getMessage());
        }
/*
        List<Product> productList = rp.getProduct();
        productList.forEach(p -> System.out.println(p.getPrice()));
        productList.forEach(p -> System.out.println(p.getBrand()));
        productList.forEach(p -> System.out.println(p.getSize()));


        List<Customer> customerList = rp.getCustomer();
        customerList.forEach(pass -> System.out.println(pass.getPassword()));
        customerList.forEach(p -> System.out.println(p.getEmail()));
*/
    }
}

