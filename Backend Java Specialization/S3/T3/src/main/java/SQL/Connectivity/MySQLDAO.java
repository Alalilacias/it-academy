package SQL.Connectivity;

import Generic.DAO;
import Generic.classes.GardenShop;
import Generic.classes.Products;
import Generic.classes.Stock;
import Generic.classes.Tickets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//TODO:
// - Check the whole thing to make sure it works.
// - Marine: deleteGardenShop(), deleteSingleGardenShop(), deleteFullStock()
// - Jorge: createTicket(), readTicketsFromEnteredStore(), updateStock()

public enum MySQLDAO implements DAO {
    INSTANCE;

    private final Logger logger = LoggerFactory.getLogger(MySQLDAO.class);
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "garden_shop";
//    User and password are based on my personal deployment, make sure to change if you're going to test
    private static final String USER = "it-academy-access";
    private static final String PASSWORD = "fneH5P95Yqmfnm";

    @Override
    public void createGardenShop(String name, ArrayList<Stock> stockList, double currentValue) {
        try(Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "INSERT INTO stores (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            int result = statement.executeUpdate();

            if (result == 0){
                logger.atError().log("Error creating garden shop. Check code.");
            }

            try(ResultSet generatedKey = statement.getGeneratedKeys()){
                if (generatedKey.next()) {
                    int id = generatedKey.getInt(1);
                    createStock(String.valueOf(id), stockList);
                }
            }
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createGardenShop(), check connection settings.");
        }
    }
    @Override
    public void createStock(String store_id, ArrayList<Stock> newStockList) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "INSERT INTO products (type, price, height, color, material) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            for (Stock stock : newStockList){
                statement.setString(1, stock.getType().name());
                statement.setDouble(2, stock.getPrice());
                statement.setObject(3, null);
                statement.setObject(4, null);
                statement.setObject(5, null);
                switch (stock.getType()){
                    case TREE -> statement.setObject(3, stock.getQuality().getName());
                    case FLOWER -> statement.setString(4, stock.getQuality().getName());
                    case DECORATION -> statement.setString(5, stock.getQuality().getName());
                }
                if(statement.executeUpdate() > 0){
                    System.out.println("Stock properly created.");
                } else {
                    System.out.println("Error creating garden shop stock. Check code.");
                }
            }
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createStock(), check connection settings.");
        }
    }
    @Override
    public int createSingleStock(String store_id, Stock stock){
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "INSERT INTO products (type, price, height, color, material) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, stock.getType().name());
            statement.setDouble(2, stock.getPrice());
            statement.setObject(3, null);
            statement.setObject(4, null);
            statement.setObject(5, null);
            switch (stock.getType()){
                case TREE -> statement.setObject(3, stock.getQuality().getName());
                case FLOWER -> statement.setString(4, stock.getQuality().getName());
                case DECORATION -> statement.setString(5, stock.getQuality().getName());
            }
            return statement.executeUpdate();
        } catch (SQLException e) {
            logger.atError().log("");
            return 0;
        }
    }
//    The only purpose of this method is to insert an already created ticket class instance into the MySQL database.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public void createTicket(String store_id, List<Products> products, double total) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {

        } catch (SQLException e) {
            logger.atError().log("");
        }
    }

    @Override
    public List<GardenShop> readGardenShops() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            List<GardenShop> gardenShops = new ArrayList<>();
            GardenShop gardenShop;
            String sql = "SELECT * FROM stores";
            PreparedStatement statement = connection.prepareStatement(sql);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    while (resultSet.next()) {
                        List<Stock> stockList = readShopStock(String.valueOf(resultSet.getInt("idstores")));
                        gardenShop = new GardenShop.Builder()
                                ._id(String.valueOf(resultSet.getInt("idstores")))
                                .name(resultSet.getString("name"))
                                .stockList(stockList)
                                .currentStockValue(0)
                                .currentSalesValue(0)
                                .build();
                        gardenShops.add(gardenShop);
                    }
                    return gardenShops;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createStock(), check connection settings.");
            return null;
        }
    }
    @Override
    public GardenShop readGardenShop(String name) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "SELECT * FROM stores WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            try(ResultSet resultSet = statement.executeQuery()){
                if(resultSet.next()){
                    List<Stock> stockList = readShopStock(String.valueOf(resultSet.getInt("idstores")));
                    return new GardenShop.Builder()
                            ._id(String.valueOf(resultSet.getInt("idstores")))
                            .name(resultSet.getString("name"))
                            .stockList(stockList)
                            .currentStockValue(0)
                            .currentSalesValue(0)
                            .build();
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createStock(), check connection settings.");
        }
        return null;
    }

    @Override
    public List<Stock> readShopStock(String gardenShop_id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {

        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at readShopStock(), check connection settings.");
            return null;
        }
        return null;
    }

//    In this method, we need to read all information from the tickets whose store_id matches the one input.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public List<Tickets> readTicketsFromEnteredStore(String store_id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {

            return null;
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createStock(), check connection settings.");
            return null;
        }
    }

//    The only purpose of this method is to update one item from the stock of a store whose id we get from input.
//    The return should be 0 if no matching product is found, 1 if found and updated and 2 if found but unable to update or you have connection issues.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public int updateStock(String store_id, Stock update) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            return 0;
        } catch (SQLException e) {
            logger.atError().log("");
            return 2;
        }
    }

//    The only purpose of this method is to update one item from the stock of a store whose id we get from input.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public boolean deleteGardenShop(String store_id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            return true;
        } catch (SQLException e) {
            logger.atError().log("");
            return false;
        }
    }

//    The only purpose of this method is to delete one item from the stock of a store whose id we get from input.
//    The return should be 0 if no matching product is found, 1 if found and updated and 2 if found but unable to update or you have connection issues.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public int deleteSingleStock(String store_id, String stock_id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            return 0;
        } catch (SQLException e) {
            logger.atError().log("");
            return 1;
        }
    }

//    The only purpose of this method is to delete all items from the stock of a store whose id we get from input.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public void deleteFullStock(String store_id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "DELETE FROM products WHERE ";

        } catch (SQLException e) {
            logger.atError().log("");
        }
    }
}
