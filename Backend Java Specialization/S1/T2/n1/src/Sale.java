package S1.T2.n1.src;

import java.util.ArrayList;
import java.util.List;

public class Sale {
//    Instance variables
    private List<Product> products;
    private int totalSalePrice;
//    Constructors
    public Sale(List<Product> products){
        this.products = products;
        this.totalSalePrice = 0;
    }
//    Getters
    public List<Product> getProducts() {
        return products;
    }
    public int getTotalSalePrice() {
        return totalSalePrice;
    }
//    Setters
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public void setTotalSalePrice(int totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }
//    Nested inner class
    private class EmptySaleException extends Exception {
        public EmptySaleException() {
            super("To make a sale you must first add products");
        }
    }
//    User-defined methods
    public void calculateTotal() throws EmptySaleException, ArrayIndexOutOfBoundsException {
        try {
            for (Product product : this.products){
                this.totalSalePrice += product.getPrice();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            if (this.products.isEmpty()){
                throw EmptySaleException;
            }
        }
    }
}
