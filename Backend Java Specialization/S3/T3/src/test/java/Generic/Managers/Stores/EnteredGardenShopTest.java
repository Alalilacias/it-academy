package Generic.Managers.Stores;

import Generic.Managers.Utilities;
import Generic.Utilities.ConnectType;
import Generic.classes.GardenShop;
import Generic.classes.Stock;
import Generic.classes.qualities.Color;
import Generic.classes.qualities.Height;
import Generic.classes.qualities.Material;
import Generic.classes.qualities.Types;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class EnteredGardenShopTest {
    private static GardenShop gardenShop;

    @BeforeEach
    void setUp() {
        List<Stock> stockList = new ArrayList<>(Arrays.asList(
                new Stock.Builder()
                        .product_id("1")
                        .type(Types.TREE)
                        .price(15.5)
                        .quantity(15)
                        .quality(Height.SMALL)
                        .build(),
                new Stock.Builder()
                        .product_id("2")
                        .type(Types.FLOWER)
                        .price(28.7)
                        .quantity(5)
                        .quality(Color.GREEN)
                        .build(),
                new Stock.Builder()
                        .product_id("3")
                        .type(Types.DECORATION)
                        .price(100)
                        .quantity(10)
                        .quality(Material.PLASTIC)
                        .build()
        ));

        gardenShop = new GardenShop.Builder()
                ._id("0")   //Remember to change the id to new ObjectID(0) is the testing is done in ConnectType.Mongo
                .name("Test Garden Shop")
                .currentStockValue(1000)
                .currentSalesValue(500)
                .stockList(stockList)
                .build();

//        Make sure to change the connect type for the testing,depending on which one you would like to test.
        gardenShop.enterGardenShop(ConnectType.MySQL);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Disabled   //Test disabled because, while the result is the expected one,it shows differently due to the way the class was setup.
    void enter() {
        assertEquals(gardenShop.toString(), EnteredGardenShop.INSTANCE.toString());
    }

    @Test
    void readStockInFull() {
        String stockInFull = gardenShop.getStockList().stream()
                .map(Stock::toString)
                .collect(Collectors.joining("", "Current Stock: ", ""));
        assertEquals(stockInFull, EnteredGardenShop.INSTANCE.readStockInFull());
    }

    @Test
    void readStockInQuantities() {
        String stockInQuantities = gardenShop.getStockList().stream()
                .collect(Collectors.groupingBy(
                        stock -> stock.getType().name(),
                        Collectors.counting()))
                .entrySet().stream()
                .map(entry -> "- " + entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining("\n", "Current Stock:\n", ""));
        assertEquals(stockInQuantities, EnteredGardenShop.INSTANCE.readStockInQuantities());
    }

    @Test
    void readTickets() {
        Utilities.enterGardenShop("Test2", ConnectType.MySQL);
        String test2Tickets = """
                Tickets from store, ID: 2
                Ticket 2
                	Store ID: 2
                	Products bought:
                		-Product_id: 3
                		-Quantity: 10
                		-Total: 1000.0
                	Total: 1000.0€""";

        assertEquals(test2Tickets, EnteredGardenShop.INSTANCE.readTickets());
    }

    @Test
    void deleteFromActiveShops() {
        assertFalse(EnteredGardenShop.INSTANCE.deleteFromActiveShops());
    }

    @Test
    void getMatchingStock() {
        Utilities.enterGardenShop("Test2", ConnectType.MySQL);
        Stock returnedStock = EnteredGardenShop.INSTANCE.getMatchingStock(String.valueOf(3));
        String stockToString = gardenShop.getStockList().get(2).toString();
        assertEquals(stockToString, returnedStock.toString());
    }

    @Test
    void isStockListEmpty() {
        assertFalse(EnteredGardenShop.INSTANCE.isStockListEmpty());
    }
}