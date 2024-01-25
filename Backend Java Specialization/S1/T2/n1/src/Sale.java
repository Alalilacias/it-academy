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
//    User-defined methods
    public void calculateTotal() {
        if (this.products.isEmpty()){
            this.products.stream().mapToDouble(Product::getPrice).sum();
        }
    }
}
