package SQL.Connectivity;

import Generic.DAO;
import Generic.classes.GardenShop;
import Generic.classes.Products;
import Generic.classes.Stock;
import Generic.classes.Tickets;
import Generic.classes.qualities.*;
import Generic.classes.qualities.Types;
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

    private static final Logger logger = LoggerFactory.getLogger(MySQLDAO.class);
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String DB = "garden_shop";
    //    User and password are based on my personal deployment, make sure to change if you're going to test
    private static final String USER = "it_academy_access";
    private static final String PASSWORD = "fneH5P95Yqmfnm";

    @Override
    public void createGardenShop(String name, ArrayList<Stock> stockList, double currentValue) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "INSERT INTO stores (name) VALUES (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            int result = statement.executeUpdate();
            statement.close();

            if (result == 0) {
                logger.atError().log("Error creating garden shop. Check code.");
            }

            try (ResultSet generatedKey = statement.getGeneratedKeys()) {
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
            String productSql = "INSERT INTO products (type, price, quality) VALUES (?, ?, ?)";
            String stockSql = "INSERT INTO stock (idstore, idproduct, quantity) VALUES (?, ?, ?)";

            PreparedStatement productStatement = connection.prepareStatement(productSql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stockStatement = connection.prepareStatement(stockSql);

            for (Stock stock : newStockList) {
                productStatement.setString(1, stock.getType().name());
                productStatement.setDouble(2, stock.getPrice());
                productStatement.setString(3, stock.getQuality().getName());

                int productResult = productStatement.executeUpdate();

                if (productResult == 0) {
                    logger.atError().log("Error creating product. Check code.");
                    continue;
                }

                try (ResultSet generatedKeys = productStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int productId = generatedKeys.getInt(1);

                        // Insert data into stock table
                        stockStatement.setString(1, store_id);
                        stockStatement.setInt(2, productId);
                        stockStatement.setInt(3, stock.getQuantity());

                        int stockResult = stockStatement.executeUpdate();

                        if (stockResult == 0) {
                            logger.atError().log("Error creating stock entry. Check code.");
                        } else {
                            System.out.println("Stock entry properly created.");
                        }
                    } else {
                        logger.atError().log("Failed to retrieve auto-generated keys for product insertion.");
                    }
                }
            }
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createStock(), check connection settings.", e);
        }
    }

    @Override
    public int createSingleStock(String store_id, Stock stock) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String productSql = "INSERT INTO products (type, price, quality) VALUES (?, ?, ?)";
            String stockSql = "INSERT INTO stock (idstore, idproduct, quantity) VALUES (?, ?, ?)";

            PreparedStatement productStatement = connection.prepareStatement(productSql, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement stockStatement = connection.prepareStatement(stockSql);

            // Insert data into products table
            productStatement.setString(1, stock.getType().name());
            productStatement.setDouble(2, stock.getPrice());
            productStatement.setString(3, stock.getQuality().getName());

            int productResult = productStatement.executeUpdate();

            if (productResult == 0) {
                logger.atError().log("Error creating product. Check code.");
                return 0;
            }

            try (ResultSet generatedKeys = productStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int productId = generatedKeys.getInt(1);

                    stockStatement.setString(1, store_id);
                    stockStatement.setInt(2, productId);
                    stockStatement.setInt(3, stock.getQuantity());

                    int stockResult = stockStatement.executeUpdate();

                    if (stockResult == 0) {
                        logger.atError().log("Error creating stock entry. Check code.");
                        return 0;
                    } else {
                        logger.info("Stock entry properly created.");
                        return 1;
                    }
                } else {
                    logger.atError().log("Failed to retrieve auto-generated keys for product insertion.");
                    return 0;
                }
            }
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createSingleStock(), check connection settings.", e);
            return 0;
        }
    }

    public void createTicket(String store_id, List<Products> products, double total) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {

            //Crear ticket
            String insertTicket = "INSERT INTO tickets (idstore, total) VALUES (?, ?)";
            PreparedStatement ticketStatement = connection.prepareStatement(insertTicket, Statement.RETURN_GENERATED_KEYS);
            ticketStatement.setString(1, store_id);
            ticketStatement.setDouble(2, total);
            ticketStatement.executeUpdate();

            //Obtener el ID del ticket
            int ticketId;
            try (java.sql.ResultSet generatedKeys = ticketStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    ticketId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating ticket failed, no ID obtained.");
                }
            }

            // Insertar las compras asociadas al ticket
            String insertPurchase = "INSERT INTO purchases (idtickets, idproduct, quantity, total) VALUES (?,?,?,?)";
            PreparedStatement purchaseStatement = connection.prepareStatement(insertPurchase);
            for (Products product : products) {
                purchaseStatement.setInt(1, ticketId);
                purchaseStatement.setInt(2, Integer.parseInt(product.getProduct_id()));
                purchaseStatement.setInt(3, product.getQuantity());
                purchaseStatement.setDouble(4, product.getTotal());
                purchaseStatement.executeUpdate();
            }

        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at createTicket(), check connection settings");
        }
    }

    @Override
    public List<GardenShop> readGardenShops() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            List<GardenShop> gardenShops = new ArrayList<>();
            GardenShop gardenShop;
            String sql = "SELECT * FROM stores";
            PreparedStatement statement = connection.prepareStatement(sql);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    while (resultSet.next()) {
                        List<Stock> stockList = readShopStock(String.valueOf(resultSet.getInt("idstores")));
                        gardenShop = new GardenShop.Builder()
                                ._id(String.valueOf(resultSet.getInt("idstores")))
                                .name(resultSet.getString("name"))
                                .stockList(stockList)
                                .currentStockValue(resultSet.getDouble("current_stock_value"))
                                .currentSalesValue(resultSet.getDouble("current_sales_value"))
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
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    List<Stock> stockList = readShopStock(String.valueOf(resultSet.getInt("idstores")));
                    return new GardenShop.Builder()
                            ._id(String.valueOf(resultSet.getInt("idstores")))
                            .name(resultSet.getString("name"))
                            .stockList(stockList)
                            .currentStockValue(resultSet.getDouble("current_stock_value"))
                            .currentSalesValue(resultSet.getDouble("current_sales_value"))
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
        List<Stock> stockList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "SELECT s.idproduct, p.type, p.price, p.quality, s.quantity " +
                    "FROM stock s " +
                    "INNER JOIN products p ON s.idproduct = p.idproducts " +
                    "INNER JOIN stores st ON s.idstore = st.idstores " +
                    "WHERE st.idstores = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gardenShop_id);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String product_id = resultSet.getString("idproduct");
                Generic.classes.qualities.Types type = switch (resultSet.getInt("type")) {
                    case 0 -> Types.TREE;
                    case 1 -> Types.FLOWER;
                    case 2 -> Types.DECORATION;
                    default -> Types.ERROR;
                };
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                Quality quality = switch (type) {
                    case TREE -> Height.valueOf(resultSet.getString("quality"));
                    case FLOWER -> Color.valueOf(resultSet.getString("quality"));
                    case DECORATION -> Material.valueOf(resultSet.getString("quality"));
                    default -> null;
                };

                Stock stock = new Stock.Builder()
                        .product_id(product_id)
                        .type(type)
                        .price(price)
                        .quantity(quantity)
                        .quality(quality)
                        .build();

                stockList.add(stock);
            }

        } catch (SQLException e) {
            logger.atError().log("Error reading shop stock. Check connection settings.", e);
        }

        return stockList;
    }

    //    In this method, we need to read all information from the tickets whose store_id matches the one input.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public List<Tickets> readTicketsFromEnteredStore(String store_id) {
        List<Tickets> ticketsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String query = "SELECT t.idtickets, t.idstore, p.idproduct, p.quantity, p.total " +
                    "FROM tickets t " +
                    "JOIN purchases p ON t.idtickets = p.idtickets " +
                    "WHERE t.idstore = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(store_id));
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int ticketId = resultSet.getInt("idtickets");
                int productId = resultSet.getInt("idproduct");
                int quantity = resultSet.getInt("quantity");
                double total = resultSet.getDouble("total");

                System.out.println("Ticket ID: " + ticketId + ", Store ID: " + store_id + ", Product ID: " + productId + ", Quantity: " + quantity + ", Total: " + total);
            }
            return ticketsList;
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at readTickets(), check connection settings.");
            return null;
        }
    }

    //    The only purpose of this method is to update one item from the stock of a store whose id we get from input.
//    The return should be 0 if no matching product is found, 1 if found and updated and 2 if found but unable to update, or you have connection issues.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public int updateStock(String store_id, Stock update) {

        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String query = "UPDATE stock SET quantity = ? WHERE idstore = ? AND idproduct = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, update.getQuantity());
            statement.setInt(2, Integer.parseInt(store_id));
            statement.setInt(3, Integer.parseInt(update.getProduct_id()));
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                return 0;
            } else if (rowsAffected == 1) {
                return 1;
            } else {
                // Se encontró más de un producto coincidente o hubo un problema de actualización
                return 2;
            }

        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at updateStock(), check connection settings.");
            return 2;
        }
    }

    //    The only purpose of this method is to update one item from the stock of a store whose id we get from input.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public boolean deleteGardenShop(String store_id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM stores WHERE idstores = ?");
            statement.setInt(1, Integer.parseInt(store_id));
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at deleteGardenShop(), check connection settings");
            return false;
        }
    }

    //    The only purpose of this method is to delete one item from the stock of a store whose id we get from input.
//    The return should be 0 if no matching product is found, 1 if found and updated and 2 if found but unable to update, or you have connection issues.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public int deleteSingleStock(String ignored, String stock_id) {
        int rowsAffected;

        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "DELETE FROM products WHERE idproducts = ?";
            String sql2 = "DELETE FROM stock WHERE idproduct = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            PreparedStatement statement2 = connection.prepareStatement(sql2);
            statement.setInt(1, Integer.parseInt(stock_id));
            statement2.setInt(1, Integer.parseInt(stock_id));
            rowsAffected = statement.executeUpdate();
            rowsAffected += statement2.executeUpdate();
            if(rowsAffected == 0){return 0;}
            return 1;
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at deleteSingleStock(), check connection settings.");
            return 2; // Return 2 to indicate connection issues or inability to update.
        }
    }

    //    The only purpose of this method is to delete all items from the stock of a store whose id we get from input.
//    Make sure you fill the logger error message that is sent if there's a connection error
    @Override
    public void deleteFullStock(String store_id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL + DB, USER, PASSWORD)) {
            String sql = "DELETE FROM products WHERE store_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(store_id));
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.atError().log("Unable to create connection at deleteFullStock(), check connection settings.");
        }
    }
}
