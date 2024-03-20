package code.classes;

public class ShoeStore {

    public static String payWith(Payments paymentType){
        double price = Math.random() * 100;
        System.out.println("Your total is " + price + "€, press enter to pay with your "
                + paymentType.name().toLowerCase().replace("_", " "));
        return paymentType.onEvent();
    }
}
