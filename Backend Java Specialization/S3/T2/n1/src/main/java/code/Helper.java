package code;

import code.classes.StockExchangeAgency;
import code.classes.StockExchangeAgent;
import code.utils.Input;

public class Helper {
    private static final StockExchangeAgent stockExchangeAgent = new StockExchangeAgent(50);
    protected static void testExercise(){
        while (true){
            switch (Input.readInt("""
                    Welcome to our Stock Exchange Agent's Office Management System™. Choose your option:
                    1. See our current state of affairs.
                    2. Add Agency to our subscription services.
                    3. Remove agency from our subscription services.
                    4. Update Stock Exchange State.
                    5. Exit.
                    """)){
                case 1:
                    seeAgentState();
                    break;
                case 2:
                    addAgency();
                    break;
                case 3:
                    removeAgency();
                    break;
                case 4:
                    updateStockExchange();
                    break;
                case 5:
                    System.out.println("Turning off, thanks for your hard work.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not an option.");
            }
        }
    }
    private static void seeAgentState(){
        System.out.println("Current State of Affairs:"
            + "\nStock Exchange: " + stockExchangeAgent.getStockExchange() + "."
            + "\nAgencies subscribed: " + stockExchangeAgent.getAgencies());
    }
    private static void addAgency(){
        String name = Input.readString("Introduce name of the agency to subscribe:");

        System.out.println("Agency " + name + " subscribed.");
        stockExchangeAgent.addObserver(new StockExchangeAgency(name));
    }
    private static void removeAgency(){
        String name = Input.readString("Introduce the name of the agency to remove");
        stockExchangeAgent.removeObserver(new StockExchangeAgency(name));
    }
    private static void updateStockExchange(){
        int newStockExchange = Input.readInt("Introduce the new value of the stock exchange:");

        stockExchangeAgent.setStockExchange(newStockExchange);
    }
}
