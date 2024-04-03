package NonSprintEvaluations.Midterm03_19_2024.src.classes;

import java.util.Map;
import java.util.stream.Collectors;

public class Orders {
    private static int currentTotalOrders = 0;
    private final int id;
    private final Clients client;
    private final Map<Products, Integer> productsList;
    private final DeliveryPerson deliveryPerson;

    public Orders(Clients client, Map<Products, Integer> productsList, DeliveryPerson deliveryPerson){
        this.id = ++currentTotalOrders;
        this.client = client;
        this.productsList = productsList;
        this.deliveryPerson = deliveryPerson;
    }

    private String getTotalPrice(){
        return this.productsList.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue() * this.deliveryPerson.getPriceMultiplier())
                .sum() + "€.";
    }
    public int getId(){
        return id;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    public String productsListToString(){
        return productsList.entrySet().stream()
                .map(entry -> entry.getKey().toString() + " Amount purchased: " + entry.getValue())
                .collect(Collectors.joining("", "\nProducts:", ""));
    }
    @Override
    public String toString() {
        return "- Order ID: " + this.id
                + "\n" + this.client
                + productsListToString()
                + "\nDelivery person: " + this.deliveryPerson
                + "\nTotal: " + getTotalPrice();
    }
}
