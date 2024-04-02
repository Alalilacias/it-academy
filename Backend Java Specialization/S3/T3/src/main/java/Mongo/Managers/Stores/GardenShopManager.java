package Mongo.Managers.Stores;

import Generic.Utilities.Input;
import Mongo.classes.GardenShop;
import Mongo.classes.Stock;
import Mongo.Connectivity.MongoDAO;
import Mongo.Managers.Stores.stock.StockManager;
import Mongo.Managers.MongoUtilities;
import Mongo.Managers.Tickets.TicketManager;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GardenShopManager {
    private static final Logger logger = LoggerFactory.getLogger(GardenShopManager.class);
    public static void createGardenShop(){
        String name = Input.readString("Introduce the name of the Garden Shop you'd like to create.");

        ArrayList<Stock> stocks = StockManager.createShopStock();

        double currentStockValue = stocks.stream()
                .mapToDouble(stock -> stock.getPrice() * stock.getQuantity())
                .sum();

        MongoDAO.INSTANCE.createGardenShop(name, stocks, currentStockValue);
    }
    public static GardenShop createGardenShopFromDocument(Document document){
        String product_id = document.getObjectId("_id").toString();
        List<Stock> stockList = document.getList("stock", Document.class).stream()
                .map(StockManager::createStockFromDocument)
                .toList();

        return new GardenShop.Builder()
                ._id(product_id)
                .name(document.getString("name"))
                .currentStockValue(document.getDouble("current_stock_value"))
                .currentSalesValue(document.getDouble("current_sales_value"))
                .stockList(stockList)
                .build();
    }
    public static void readActiveGardenShops(){
        List<GardenShop> activeGardenShops = MongoDAO.INSTANCE.readGardenShops();
        if(activeGardenShops == null){
            logger.atError().log("MongoDAO.INSTANCE.readGardenShops() == null, check it.");
            return;
        }

        String activeGardenShopPrintable;
        if (activeGardenShops.isEmpty()){
            activeGardenShopPrintable = "Current Active Garden Shops:\n- Empty";
        } else {
            activeGardenShopPrintable = activeGardenShops.stream()
                    .map(GardenShop::toString)
                    .collect(Collectors.joining("", "Current Active Garden Shops:", ""));
        }

        System.out.println(activeGardenShopPrintable);
    }
    public static void enterGardenShop(){
        String name = Input.readString("Introduce the name of the Garden Shop whose Management System you'd like to enter.");

        boolean isInDatabase = MongoUtilities.enterGardenShop(name);

        if (!isInDatabase){
            System.out.println("That garden shop isn't registered in our system.");
            return;
        }

        while(true){
            switch (Input.readInt(EnteredGardenShop.INSTANCE
                    + """
                        0. Exit store.
                        1. See current Stock.
                        2. Update Stock.
                        3. See Past Tickets.
                        4. Create Ticket.
                        5. Inform HQ of Bankruptcy.
                        """)){
                case 0 -> {return;}
                case 1 -> StockManager.readStock();
                case 2 -> StockManager.updateStock();
                case 3 -> TicketManager.readPastTickets();
                case 4 -> TicketManager.createTicket();
                case 5 -> { if (EnteredGardenShop.INSTANCE.deleteFromActiveShops()) return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
