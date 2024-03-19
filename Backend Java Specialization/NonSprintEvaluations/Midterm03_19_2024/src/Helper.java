package NonSprintEvaluations.Midterm03_19_2024.src;

import NonSprintEvaluations.Midterm03_19_2024.src.classes.*;
import S1.T2.n2.exercise1.src.classes.Input;

import java.util.*;

public class Helper {
    private static final List<DeliveryPerson> availableDeliveryPeople = Arrays.asList(
            new DeliveryPerson.Builder()
                    .name("Hermenegildo")
                    .methodOfTransportation(MethodOfTransportation.FOOT)
                    .build(),
            new DeliveryPerson.Builder()
                    .name("Robustiana")
                    .methodOfTransportation(MethodOfTransportation.BICYCLE)
                    .build(),
            new DeliveryPerson.Builder()
                    .name("Amasvindo")
                    .methodOfTransportation(MethodOfTransportation.MOTORCYCLE)
                    .build(),
            new DeliveryPerson.Builder()
                    .name("Fulgencio")
                    .methodOfTransportation(MethodOfTransportation.FOOT)
                    .build(),
            new DeliveryPerson.Builder()
                    .name("Pantaleona")
                    .methodOfTransportation(MethodOfTransportation.BICYCLE)
                    .build(),
            new DeliveryPerson.Builder()
                    .name("Veneranda")
                    .methodOfTransportation(MethodOfTransportation.MOTORCYCLE)
                    .build()
    );
    private static final List<Orders> pendingOrders = new ArrayList<>();
    private static final List<Orders> deliveredOrders = new ArrayList<>();
    protected static void testExercise(){
        //noinspection InfiniteLoopStatement
        while (true) {
            switch ((Input.readInt("""
                    Welcome to GenericFastFood™, what would our dearest employee like to do?
                    1. Create a new order.
                    2. Mark an order as delivered.
                    3. List pending orders.
                    4. List delivered orders.
                    Input your utmost desire after this:
                    """))){
                case 1:
                    createOrder();
                    break;
                case 2:
                    markOrderAsDelivered();
                    break;
                case 3:
                    System.out.println(pendingOrders);
                    break;
                case 4:
                    System.out.println(deliveredOrders);
                    break;
                default:
                    System.out.println("That option is not included, try again dearest.");
            }
        }
    }

    private static void createOrder(){

        if (availableDeliveryPeople.isEmpty()){
            throw new RuntimeException("There is no one left who wants to work in this country!");
        }

        int quantity;
        String clientName, clientAddress;
        Map<Products, Integer> tempMap = new HashMap<>();
        DeliveryPerson deliveryPerson = selectDeliveryPerson();

        clientName = Input.readString("Please input client's name:");
        clientAddress = Input.readString("Please input client's address:");

        quantity = Input.readInt("How many burritos would the client like?");
        if (quantity > 0){
            tempMap.put(Products.BURRITOS, quantity);
        }
        quantity = Input.readInt("How many burgers would the client like?");
        if (quantity > 0){
            tempMap.put(Products.BURGERS, quantity);
        }
        quantity = Input.readInt("How many kebabs would the client like?");
        if (quantity > 0){
            tempMap.put(Products.KEBAB, quantity);
        }
        quantity = Input.readInt("How many pizzas would the client like?");
        if (quantity > 0){
            tempMap.put(Products.PIZZA, quantity);
        }

        if (tempMap.isEmpty()){
            System.out.println("Order is empty, returning you to main menu.");
            return;
        }

        boolean orderCorrect = Input.readIfNo("Is the order information correct?"
                                    + "\n- Client's name: " + clientName
                                    + "\n- Client's address: " + clientAddress
                                    + "\n- Products:" + printMap(tempMap));

        if (orderCorrect){
            pendingOrders.add(new Orders(new Clients(clientName, clientAddress), tempMap, deliveryPerson));
            System.out.println("Order created.");
        }
    }
    private static String printMap(Map<Products, Integer> map){
        StringBuilder stringBuilder = new StringBuilder();
        for (Products key : map.keySet()){
            stringBuilder.append("\n\t- ").append(key.name()).append(", amount: ").append(map.get(key));
        }

        return stringBuilder.toString();
    }
    private static DeliveryPerson selectDeliveryPerson(){
        int index = new Random().nextInt(availableDeliveryPeople.size());

        DeliveryPerson deliveryPerson = availableDeliveryPeople.get(index);
        availableDeliveryPeople.remove(index);

        return deliveryPerson;
    }
    private static void markOrderAsDelivered(){
        int idToMarxAsDelivered = Input.readInt(pendingOrders + "\nIntroduce the ID of the order to mark as delivered.");
        int index;

        for (Orders order : pendingOrders) {
            if (order.getId() == idToMarxAsDelivered){
                index = pendingOrders.indexOf(order);
                deliveredOrders.add(pendingOrders.get(index));
                availableDeliveryPeople.add(pendingOrders.get(index).getDeliveryPerson());
                pendingOrders.remove(index);
                System.out.println("Order " + idToMarxAsDelivered + " marked as delivered."
                                + order.getDeliveryPerson().getName() + " is available to deliver again.");
                return;
            }
        }

        System.out.println("No pending order found with the given id.");
    }
}
