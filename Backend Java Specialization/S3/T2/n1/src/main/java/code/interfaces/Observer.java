package code.interfaces;

import code.classes.StockExchangeAgency;

public interface Observer {
    void update(String notification);

    int compareTo(StockExchangeAgency stockExchangeAgency);
}
