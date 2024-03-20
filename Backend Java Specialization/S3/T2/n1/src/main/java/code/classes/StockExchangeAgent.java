package code.classes;

import code.interfaces.Observable;
import code.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class StockExchangeAgent implements Observable {
    private final List<Observer> agencies = new ArrayList<>();
    private int stockExchange;

    public StockExchangeAgent(int currentValueOfStockExchange){
        this.stockExchange = currentValueOfStockExchange;
    }

    public List<Observer> getAgencies() {
        return agencies;
    }
    public int getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(int stockExchange) {
        String notification = "The stock exchange has gone " +
                ((stockExchange > this.stockExchange) ? "up." : "down.");

        notifyObservers(notification);
        this.stockExchange = stockExchange;
    }
    @Override
    public void addObserver(Observer observer) {
        agencies.add(observer);
    }
    @Override
    public void removeObserver(Observer observerToRemove) {
        String textToPrint = (agencies.removeIf(observer -> (observer.compareTo((StockExchangeAgency) observerToRemove) == 0))) ?
                "Agency's subscription removed." : "Agency wasn't found in out subscription database.";
        System.out.println(textToPrint);
    }
    @Override
    public void notifyObservers(String message) {
        for(Observer observer : agencies){
            observer.update(message);
        }
    }
}
