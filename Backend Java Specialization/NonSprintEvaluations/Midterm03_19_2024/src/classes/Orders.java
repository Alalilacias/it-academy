package NonSprintEvaluations.Midterm03_19_2024.src.classes;

import java.util.Map;

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
        return this.productsList.keySet().stream()
                .map(Products::getPrice)
                .mapToDouble(price -> Integer.parseInt(price) * this.deliveryPerson.getPriceMultiplier())
                .sum() + "€.";
    }
    public int getId(){
        return id;
    }

    public DeliveryPerson getDeliveryPerson() {
        return deliveryPerson;
    }

    @Override
    public String toString() {
        return "- Order ID: " + this.id
                + "\n\t" + this.client
                + "Products: " + this.productsList
                + "Delivery person: " + this.deliveryPerson
                + "Total: " + getTotalPrice();
    }
}
