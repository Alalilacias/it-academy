package SQL.Connectivity;

import Generic.DAO;
import Mongo.classes.GardenShop;
import Mongo.classes.Products;
import Mongo.classes.Stock;
import Mongo.classes.Tickets;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public enum MySQLDAO implements DAO {
    INSTANCE;

    private final Logger logger = LoggerFactory.getLogger(MySQLDAO.class);
    private static final String HOST = "jdbc:mysql://localhost:3306/";
    private static final String DB = "Garden_Shop";
    private static final String USER = "root";
    private static final String PASS = "1234";

    MySQLDAO(){
        try(Connection ignored = DriverManager.getConnection(HOST + DB, USER, PASS)) {
            System.out.println("Connection properly made.");
        } catch (SQLException e) {
            logger.atError().log("Error connecting to MySQL Database, check settings.");
            System.exit(0);
        }
    }
    @Override
    public void createGardenShop(String name, ArrayList<Stock> stockList, double currentValue) {

    }
    @Override
    public void createStock(String store_id, ArrayList<Stock> newStockList) {

    }
    @Override
    public void createTicket(String store_id, List<Products> products, double total) {

    }
    @Override
    public List<GardenShop> readGardenShops() {
        return null;
    }
    @Override
    public Document readGardenShop(String name) {
        return null;
    }
    @Override
    public List<Stock> readShopStock(String gardenShop_id) {
        return null;
    }
    @Override
    public List<Tickets> readTicketsFromEnteredStore(String store_id) {
        return null;
    }
    @Override
    public int updateStock(String store_id, Stock update) {
        return 0;
    }
    @Override
    public boolean deleteGardenShop(String store_id) {
        return false;
    }
    @Override
    public int deleteSingleStock(String store_id, String stock_id) {
        return 0;
    }
    @Override
    public void deleteFullStock(String store_id) {

    }
}
