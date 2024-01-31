package S1.T2.n1.exercise1.src;

import S1.T2.n1.exercise1.src.classes.Product;
import S1.T2.n1.exercise1.src.classes.Sale;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static void main(String[] args) {
//        Instantiation of products list for sale creation.
        List<Product> products = new ArrayList<>();
//        Instantiation of sale
        Sale sale = new Sale(products);
//        Usage of calculateTotal() method with empty list to test EmptySaleException
        sale.calculateTotal();
//        Product creation and introduction into List
        products.add(new Product("Shoe", 15));
        products.add(new Product("Table", 30));
//        Usage of calculateTotal() method with filled List
        sale.calculateTotal();
    }
}
