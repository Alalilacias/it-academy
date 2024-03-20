package code.classes;

import code.interfaces.Observer;

public record StockExchangeAgency(String name) implements Observer {

    @Override
    public String toString() {
        return "\n- " + this.name + ".";
    }

    @Override
    public void update(String notification) {
        System.out.println(this.name + " has received the following notification: \"" + notification + "\".");
    }

    @Override
    public int compareTo(StockExchangeAgency stockExchangeAgency) {
        return this.name().compareTo(stockExchangeAgency.name());
    }
}
