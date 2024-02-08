package S1.T2.n1.exercise1.src.classes;

import java.util.List;

public class Sale {
//    Instance variables
    private final List<Product> products;
    private int totalSalePrice;
//    Constructors
    public Sale(List<Product> products){
        this.products = products;
        this.totalSalePrice = 0;
    }

    /*User-defined methods. CalculateTotal, as requested by the exercise, tries to calculate the price total
     * and catches the IndexOutOfBoundsException, throwing EmptySaleException if the array is empty and the caught
     * ArrayIndexOutOfBoundsException if it is not, allowing the programmer to discern when the exception is caused
     * by a mistake in the code or due to the List being empty. */
    public void saleCalculation() throws EmptySaleException {
        if (this.products.isEmpty()) {
            throw new EmptySaleException();
        }
        for (Product product : this.products) {
            this.totalSalePrice += product.getPrice();
        }
    }
    public void calculateTotal() {
        try {
            saleCalculation();
            System.out.println("Total sale price is: " + this.totalSalePrice + "€.");
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }
    }
}
